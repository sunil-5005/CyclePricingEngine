package com.pricingengine.components.wheel.parts.tyre;

public class Tube {

	private double price;

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Tube [price=" + price + "]";
	}

}
