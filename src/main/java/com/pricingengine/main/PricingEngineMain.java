package com.pricingengine.main;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.core.io.ClassPathResource;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pricingengine.vehicle.CycleOrder;

/**
 * Hello world!
 *
 */
public class PricingEngineMain {
	public static void main(String[] args) throws IOException, InterruptedException {

		// create ObjectMapper instance
		ObjectMapper objectMapper = new ObjectMapper();

		// convert json string to object
		List<Map<String, Map<String, String>>> ordersList = objectMapper.readValue(new ClassPathResource("com/pricingengine/resources/cycleorder.json").getFile(), List.class);
		
		PricingEngineHelper.processOrder(ordersList);
	}
}
