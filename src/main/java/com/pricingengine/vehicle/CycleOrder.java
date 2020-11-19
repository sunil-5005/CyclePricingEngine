package com.pricingengine.vehicle;

import java.util.Map;

public class CycleOrder {

	private Map<String, String> frame;
	private Map<String, String> handleBar;
	private Map<String, String> wheels;
	private Map<String, String> chainAssembly;
	private String purchasingDate;
	private boolean isOrderProcessed;

	public Map<String, String> getFrame() {
		return frame;
	}

	public void setFrame(Map<String, String> frame) {
		this.frame = frame;
	}

	public Map<String, String> getHandleBar() {
		return handleBar;
	}

	public void setHandleBar(Map<String, String> handleBar) {
		this.handleBar = handleBar;
	}

	public Map<String, String> getWheels() {
		return wheels;
	}

	public void setWheels(Map<String, String> wheels) {
		this.wheels = wheels;
	}

	public Map<String, String> getChainAssembly() {
		return chainAssembly;
	}

	public void setChainAssembly(Map<String, String> chainAssembly) {
		this.chainAssembly = chainAssembly;
	}

	public String getPurchasingDate() {
		return purchasingDate;
	}

	public void setPurchasingDate(String purchasingDate) {
		this.purchasingDate = purchasingDate;
	}

	public boolean isOrderProcessed() {
		return isOrderProcessed;
	}

	public void setOrderProcessed(boolean isOrderProcessed) {
		this.isOrderProcessed = isOrderProcessed;
	}

	@Override
	public String toString() {
		return "CycleOrder [frame=" + frame + ", handleBar=" + handleBar + ", wheels=" + wheels + ", chainAssembly="
				+ chainAssembly + ", purchasingDate=" + purchasingDate + ", isOrderProcessed=" + isOrderProcessed + "]";
	}

}