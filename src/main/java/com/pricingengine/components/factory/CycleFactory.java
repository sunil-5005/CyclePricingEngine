package com.pricingengine.components.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.pricingengine.components.breaks.Break;
import com.pricingengine.components.breaks.DiscBreak;
import com.pricingengine.components.breaks.DrumBreak;
import com.pricingengine.components.common.ChainAssembly;
import com.pricingengine.components.common.HandleBar;
import com.pricingengine.components.common.Pedal;
import com.pricingengine.components.common.Seat;
import com.pricingengine.components.frame.AluminimumFrame;
import com.pricingengine.components.frame.Frame;
import com.pricingengine.components.frame.SteelFrame;
import com.pricingengine.components.wheel.Wheel;
import com.pricingengine.components.wheel.parts.rim.AlloyRim;
import com.pricingengine.components.wheel.parts.rim.Rim;
import com.pricingengine.components.wheel.parts.rim.SpokeRim;
import com.pricingengine.components.wheel.parts.tyre.Tube;
import com.pricingengine.components.wheel.parts.tyre.TubelessTyre;
import com.pricingengine.components.wheel.parts.tyre.Tyre;
import com.pricingengine.components.wheel.parts.tyre.TyreWithTube;
import com.pricingengine.vehicle.Cycle;
import com.pricingengine.vehicle.CycleOrder;

public class CycleFactory {

	private static Properties component_prices = new Properties();
	static {
		try {
			component_prices.load(new FileInputStream(
					new File("src/main/resources/component_prices.properties")));
			System.out.println("Loaded component_prices successfully: " + component_prices);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static Cycle buildCycle(CycleOrder order) {
		Cycle cycle = new Cycle();

		cycle.setFrame(buildFrame(order.getFrame()));
		cycle.setHandleBar(buildHandleBar(order.getHandleBar()));

		List<Wheel> wheels = new ArrayList<>();
		wheels.add(buildWheel(order.getWheels()));// front
		wheels.add(buildWheel(order.getWheels()));// rear

		cycle.setWheels(wheels);

		cycle.setChainAssembly(buildChainAssembly(Integer.parseInt(order.getChainAssembly().get("noOfGears"))));

		cycle.setSeat(getSeat());

		cycle.setManufacturingDate(order.getPurchasingDate());

		return cycle;
	}

	public static Seat getSeat() {
		Seat seat = new Seat();
		seat.setPrice(getComponentPrice("cycle.seat"));

		return seat;
	}

	public static Frame buildFrame(Map<String, String> frameRequirement) {

		Frame frame = null;

		if (frameRequirement.get("materialtype").equals("steel")) {
			frame = new SteelFrame();
			frame.setPrice(getComponentPrice("cycle.frame.steel"));
		} else {
			frame = new AluminimumFrame();
			frame.setPrice(getComponentPrice("cycle.frame.aluminium"));
		}

		frame.setColor(frameRequirement.get("color"));

		return frame;
	}

	public static HandleBar buildHandleBar(Map<String, String> handleBarRequirement) {

		HandleBar handleBar = new HandleBar();

		handleBar.setFrontBreak(getBreak(handleBarRequirement.get("frontBreak")));
		handleBar.setRearBreak(getBreak(handleBarRequirement.get("rearBreak")));

		handleBar.setColor(handleBarRequirement.get("color"));
		handleBar.setPrice(getComponentPrice("cycle.handlebar") + handleBar.getFrontBreak().getPrice()
				+ handleBar.getRearBreak().getPrice());

		return handleBar;
	}

	public static Break getBreak(String breakType) {
		Break brk = null;

		if (breakType.equals("disc")) {
			brk = new DiscBreak();
			brk.setPrice(getComponentPrice("cycle.break.discbreak"));
		} else {
			brk = new DrumBreak();
			brk.setPrice(getComponentPrice("cycle.break.drumbreak"));
		}

		return brk;
	}

	public static Wheel buildWheel(Map<String, String> wheelRequirement) {

		Wheel wheel = new Wheel();

		wheel.setRim(getRim(wheelRequirement.get("rimtype")));
		wheel.setTyre(getTyre(wheelRequirement.get("tyretype")));

		wheel.setPrice(wheel.getRim().getPrice() + wheel.getTyre().getPrice());

		return wheel;
	}

	public static Rim getRim(String rimType) {
		Rim rim = null;

		if (rimType.equals("alloy")) {
			rim = new AlloyRim();
			rim.setPrice(getComponentPrice("cycle.rim.alloy"));
		} else {
			rim = new SpokeRim();
			rim.setPrice(getComponentPrice("cycle.rim.spoke"));
		}

		return rim;
	}

	public static Tyre getTyre(String tyreType) {
		Tyre tyre = null;

		if (tyreType.equals("tubeless")) {
			tyre = new TubelessTyre();
			tyre.setPrice(getComponentPrice("cycle.tyre.tubeless"));
		} else {
			Tube tube = new Tube();
			tube.setPrice(getComponentPrice("cycle.tyre.tube"));

			tyre = new TyreWithTube();
			tyre.setTube(tube);
			tyre.setPrice(getComponentPrice("cycle.tyre") + tube.getPrice());
		}

		return tyre;
	}

	public static ChainAssembly buildChainAssembly(int noOfGears) {

		ChainAssembly chainAssembly = new ChainAssembly();

		Pedal pedal = new Pedal();

		chainAssembly.setNoOfGears(noOfGears);
		chainAssembly.setPedal(pedal);
		chainAssembly.setPrice(getComponentPrice("cycle.tyre") + chainAssembly.getPedal().getPrice());

		return chainAssembly;
	}

	private static double getComponentPrice(String componentName) {

		return Double.parseDouble(component_prices.get(componentName) + "");
	}

}