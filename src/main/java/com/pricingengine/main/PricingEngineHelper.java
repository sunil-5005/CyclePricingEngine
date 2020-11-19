package com.pricingengine.main;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pricingengine.components.factory.worker.CycleBuilder;
import com.pricingengine.components.wheel.Wheel;
import com.pricingengine.vehicle.Cycle;
import com.pricingengine.vehicle.CycleOrder;

public class PricingEngineHelper {
	private static final int MAX_THREADS = 5;
	private static final double PRICE_HIKE_PERCENTAGE = 0.02;

	public static String processOrder(List<Map<String, Map<String, String>>> ordersList)
			throws JsonMappingException, JsonProcessingException, InterruptedException {

		BlockingQueue<CycleOrder> ordersQ = new LinkedBlockingDeque<>();
		List<Cycle> cycles = Collections.synchronizedList(new ArrayList<>());

		System.out.println("Processing Orders: " + ordersList);

		for (Map<String, Map<String, String>> order : ordersList) {
			CycleOrder co = new CycleOrder();
			co.setFrame(order.get("frame"));
			co.setHandleBar(order.get("handleBar"));
			co.setWheels(order.get("wheels"));
			co.setChainAssembly(order.get("chainAssembly"));
			co.setPurchasingDate(order.get("purchasingDate") + "");
			ordersQ.put(co);
		}

		Runnable worker = new CycleBuilder(ordersQ, cycles);
		ExecutorService executor = Executors.newFixedThreadPool(MAX_THREADS);

		for (int i = 0; i < MAX_THREADS; i++) {
			executor.execute(worker);
		}

		executor.shutdown();
		executor.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS);

		ObjectMapper objectMapper = new ObjectMapper();
		String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(cycles);
		System.out.println("Processed Order: " + json);

		return json;

	}

	public static void runPricingEngine(Cycle cycle) {
		
		double price = 0.0;
		
		price = cycle.getFrame().getPrice() +
				cycle.getHandleBar().getPrice() +
				cycle.getChainAssembly().getPrice() +
				cycle.getSeat().getPrice();
				
		
//		calculate wheels price
		
		for(Wheel wheel : cycle.getWheels())
			price += wheel.getPrice();
		
		price = price + (price * getPriceHikePercentage(cycle.getManufacturingDate()));
		
		cycle.setPrice(price);
		
		
	}

	private static double getPriceHikePercentage(String manufacturingDate) {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
		String date = "1/12/2016";
		double hikePercentage = 0.0;

		// convert String to LocalDate
		LocalDate localDate = LocalDate.parse(date, formatter);
		LocalDate mfgDate = LocalDate.parse(manufacturingDate, formatter);

		if (localDate.compareTo(mfgDate) <= 0) {
			hikePercentage = PRICE_HIKE_PERCENTAGE;
		} else {
			hikePercentage = 0;
		}
		
		System.out.println("Price is Hiked by " + hikePercentage + " Percentage");
		
		return hikePercentage;
	}

}