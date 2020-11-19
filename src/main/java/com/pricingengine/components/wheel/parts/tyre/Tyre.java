package com.pricingengine.components.wheel.parts.tyre;

public abstract class Tyre {
	private Tube tube;
	private double price;

	public Tube getTube() {
		return tube;
	}

	public void setTube(Tube tube) {
		this.tube = tube;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Tyre [tube=" + tube + ", price=" + price + "]";
	}

}
