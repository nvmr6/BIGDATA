package strategy2.step5.modularization;

import strategy2.step5.component.IEngine;
import strategy2.step5.component.Ifuel;
import strategy2.step5.component.Ikm;

public class Car {
	private IEngine engine;
	private Ikm km;
	private Ifuel fuel;
	
	public void shape() {
		 System.out.println("은(는) door, sheet, handle로 이루어져 있습니다.");
	 }
    public void drive() {
		 System.out.println("주행이 가능합니다.");
	 }
	public void isEngine() {
		 engine.engine();
	 }
	public void isKm() {
		 km.km();
	 }
	public void isFuel() {
		 fuel.fuel();
	 }

	public void setEngine(IEngine engine) {
		this.engine = engine;
	}

	public void setKm(Ikm km) {
		this.km = km;
	}

	public void setFuel(Ifuel fuel) {
		this.fuel = fuel;
	}
}
