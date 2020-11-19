package com.pricingengine.components.common;

import com.pricingengine.components.breaks.Break;

public class HandleBar {

	private String color;
	private Break frontBreak;
	private Break rearBreak;
	private double price;

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Break getFrontBreak() {
		return frontBreak;
	}

	public void setFrontBreak(Break frontBreak) {
		this.frontBreak = frontBreak;
	}

	public Break getRearBreak() {
		return rearBreak;
	}

	public void setRearBreak(Break rearBreak) {
		this.rearBreak = rearBreak;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "HandleBar [color=" + color + ", frontBreak=" + frontBreak + ", rearBreak=" + rearBreak + ", price="
				+ price + "]";
	}

}