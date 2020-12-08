package com.lec.ex07_car;

import com.lec.cons.CarSpecs;

public class TestMain {
	public static void main(String[] args) {
		Car lcar = new LowGradeCar(CarSpecs.COLOR_BLUE, CarSpecs.TIRE_NORMAL, CarSpecs.DISPLACEMENT_2000, CarSpecs.HANDLE_POWER);
		Car hcar = new HighGradeCar(CarSpecs.COLOR_RED, CarSpecs.TIRE_WIDE, CarSpecs.DISPLACEMENT_2200, CarSpecs.HANDLE_POWER);
		lcar.getSpec();
		hcar.getSpec();
	}
}
