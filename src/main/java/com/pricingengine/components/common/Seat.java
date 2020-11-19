package com.pricingengine.components.common;

public class Seat {
	private double price;

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Seat [price=" + price + "]";
	}
	
}
