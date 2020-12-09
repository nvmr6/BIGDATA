package com.lec.ex07_toy;

public class AirplaneToy implements IMissile, ILight{	
	public AirplaneToy() {
		System.out.println("비행기 장난감");
		canLight();
		canMissile();
		System.out.println("");
	}

	@Override
	public void canLight() {
		System.out.println("불빛 반사");
	}

	@Override
	public void canMissile() {
		System.out.println("미사일 발사");
	}
	
	@Override
	public String toString() {
		return "불빛 반사와 미사일 발사 가능한 비행기 장난감";
	}
}	
