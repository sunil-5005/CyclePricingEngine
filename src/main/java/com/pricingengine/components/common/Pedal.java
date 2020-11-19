package com.pricingengine.components.common;

public class Pedal {

	private double price;

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Pedal [price=" + price + "]";
	}

	
}
