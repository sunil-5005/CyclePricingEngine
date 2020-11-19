package com.pricingengine.components.wheel.parts.rim;

public abstract class Rim {
	private double price;

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Rim [price=" + price + "]";
	}

}
