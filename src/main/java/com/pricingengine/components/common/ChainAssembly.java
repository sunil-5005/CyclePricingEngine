package com.pricingengine.components.common;

public class ChainAssembly {
	private int noOfGears;
	private Pedal pedal;
	private double price;

	public int getNoOfGears() {
		return noOfGears;
	}

	public void setNoOfGears(int noOfGears) {
		this.noOfGears = noOfGears;
	}

	public Pedal getPedal() {
		return pedal;
	}

	public void setPedal(Pedal pedal) {
		this.pedal = pedal;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "ChainAssembly [noOfGears=" + noOfGears + ", pedal=" + pedal + ", price=" + price + "]";
	}

}