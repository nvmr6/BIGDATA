package strategy2.step5.modularization;

import strategy2.step5.component.FuelHybrid;
import strategy2.step5.component.Km15;

public class TestMain {
	public static void main(String[] args) {
		Car accent = new Accent();
		Car sonata = new Sonata();
		Car genesis = new Genesis();
		
		Car[] cars = {accent, sonata, genesis};
		
		for(Car temp: cars) {
			temp.shape();
			temp.drive();
			temp.isEngine();
			temp.isKm();
			temp.isFuel();
			System.out.println("");
		}
		
		//업그레이드
		sonata.setFuel(new FuelHybrid());
		genesis.setKm(new Km15());
		
		for(Car temp: cars) {
			temp.shape();
			temp.drive();
			temp.isEngine();
			temp.isKm();
			temp.isFuel();
			System.out.println("");
		}
	}
}
