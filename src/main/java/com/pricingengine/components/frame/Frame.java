package com.pricingengine.components.frame;

public abstract class Frame {
	private String color;
	private double price;

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Frame [color=" + color + ", price=" + price + "]";
	}
	
	

}
