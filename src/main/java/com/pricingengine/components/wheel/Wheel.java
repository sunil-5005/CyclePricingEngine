package com.pricingengine.components.wheel;

import com.pricingengine.components.wheel.parts.rim.Rim;
import com.pricingengine.components.wheel.parts.tyre.Tyre;

public class Wheel {

	private Rim rim;
	private Tyre tyre;
	private double price;

	public Rim getRim() {
		return rim;
	}

	public void setRim(Rim rim) {
		this.rim = rim;
	}

	public Tyre getTyre() {
		return tyre;
	}

	public void setTyre(Tyre tyre) {
		this.tyre = tyre;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Wheel [rim=" + rim + ", tyre=" + tyre + ", price=" + price + "]";
	}

}
