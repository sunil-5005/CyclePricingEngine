package com.pricingengine.vehicle;

import java.util.List;

import com.pricingengine.components.common.ChainAssembly;
import com.pricingengine.components.common.HandleBar;
import com.pricingengine.components.common.Seat;
import com.pricingengine.components.frame.Frame;
import com.pricingengine.components.wheel.Wheel;

public class Cycle {

	private Frame frame;
	private HandleBar handleBar;
	private List<Wheel> wheels;
	private ChainAssembly chainAssembly;
	private Seat seat;
	private double price;
	private String manufacturingDate;

	public Frame getFrame() {
		return frame;
	}

	public void setFrame(Frame frame) {
		this.frame = frame;
	}

	public HandleBar getHandleBar() {
		return handleBar;
	}

	public void setHandleBar(HandleBar handleBar) {
		this.handleBar = handleBar;
	}

	public List<Wheel> getWheels() {
		return wheels;
	}

	public void setWheels(List<Wheel> wheels) {
		this.wheels = wheels;
	}

	public ChainAssembly getChainAssembly() {
		return chainAssembly;
	}

	public void setChainAssembly(ChainAssembly chainAssembly) {
		this.chainAssembly = chainAssembly;
	}

	public Seat getSeat() {
		return seat;
	}

	public void setSeat(Seat seat) {
		this.seat = seat;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getManufacturingDate() {
		return manufacturingDate;
	}

	public void setManufacturingDate(String manufacturingDate) {
		this.manufacturingDate = manufacturingDate;
	}

	@Override
	public String toString() {
		return "Cycle [frame=" + frame + ", handleBar=" + handleBar + ", wheels=" + wheels + ", chainAssembly="
				+ chainAssembly + ", seat=" + seat + ", price=" + price + ", manufacturingDate=" + manufacturingDate
				+ "]";
	}

}