package com.lec.ex03_phone;

public class BModel implements IAcor {
	private String model = "B모델";

	@Override
	public void dmbReceive() {
		System.out.println(model + "은 DMB 송신 가능");
	}

	@Override
	public void lte() {
		System.out.println(model + "은 LTE 통신 모뎀");
	}

	@Override
	public void tvremoteControl() {
		System.out.println(model + "은 TV리모콘 탑재");
	}
			
}
