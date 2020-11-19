package com.pricingengine.main;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * This is the main class to bootup the application
 * @author Sunil Shekade
 *
 */
public class PricingEngineMain {
	public static void main(String[] args) throws IOException, InterruptedException {

		Scanner scn = new Scanner(System.in);

		System.out.println(" ** Welcome to Cycle Factory **");
		System.out.println();
		System.out.println("How would you like to submit your order? \n Please select an option: ");
		System.out.println("1. JSONArray String");
		System.out.println("2. JSONArray file");
		int option = scn.nextInt();

		// create ObjectMapper instance
		ObjectMapper objectMapper = new ObjectMapper();

		// convert json string to object
		List<Map<String, Map<String, String>>> ordersList = null;

		if (option == 1) {
			System.out.println("Please enter a order JSON String: ");
			String json = scn.next();

			ordersList = objectMapper.readValue(json, List.class);

		} else if (option == 2) {
			System.out.println("Please enter a order JSON file path (Fully Qualified path): ");
			String jsonPath = scn.next();

			ordersList = objectMapper.readValue(new File(jsonPath), List.class);
			
		} else {
			System.out.println("Please select a valid option.");
		}

		PricingEngineHelper.processOrder(ordersList);

		scn.close();
	}
}
