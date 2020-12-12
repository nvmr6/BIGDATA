package strategy2.step5.modularization;

import strategy2.step5.component.EngineLow;
import strategy2.step5.component.FuelDiesel;
import strategy2.step5.component.Km20;

public class Accent extends Car{
	
	public Accent() {
		setEngine(new EngineLow());
		setKm(new Km20());
		setFuel(new FuelDiesel());
	}//부속품
	
	@Override
	public void shape() {
		System.out.print("액센트");
		super.shape();// door, sheet, handle
	}
}
