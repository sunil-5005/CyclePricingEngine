package com.pricingengine.components.wheel.parts.tyre;

public class TubelessTyre extends Tyre{
	
	public Tube getTube() {
		return null;
	}

	public void setTube(Tube tube) {
		super.setTube(null);		
	}
	
}
