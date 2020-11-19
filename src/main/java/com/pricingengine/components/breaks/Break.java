package com.pricingengine.components.breaks;

public abstract class Break {
	private double price;

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Break [price=" + price + "]";
	}

}
