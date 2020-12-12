package strategy2.step5.modularization;

import strategy2.step5.component.EngineMid;
import strategy2.step5.component.FuelGasoline;
import strategy2.step5.component.Km15;

public class Sonata extends Car{
	
	public Sonata() {
		setEngine(new EngineMid());
		setKm(new Km15());
		setFuel(new FuelGasoline());
	}//부속품
	
	@Override
	public void shape() {
		System.out.print("소나타");
		super.shape();// door, sheet, handle
	}
}
