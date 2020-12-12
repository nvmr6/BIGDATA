package strategy2.step5.modularization;

import strategy2.step5.component.EngineHigh;
import strategy2.step5.component.FuelGasoline;
import strategy2.step5.component.Km10;

public class Genesis extends Car{
	
	public Genesis() {
		setEngine(new EngineHigh());
		setKm(new Km10());
		setFuel(new FuelGasoline());
	}//부속품
	
	@Override
	public void shape() {
		System.out.print("제네시스");
		super.shape();// door, sheet, handle
	}
}
