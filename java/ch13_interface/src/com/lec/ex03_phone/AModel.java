package com.lec.ex03_phone;

public class AModel implements IAcor{
	private String model = "A모델";

	@Override
	public void dmbReceive() {
		System.out.println(model + "은 DMB 송신 가능");
	}

	@Override
	public void lte() {
		System.out.println(model + "은 5G 통신 모뎀");
	}

	@Override
	public void tvremoteControl() {
		System.out.println(model + "은 TV 리모콘 미탑재");
	}
	
}
