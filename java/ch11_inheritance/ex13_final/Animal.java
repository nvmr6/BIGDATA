package com.lec.ex13_final;

public class Animal {
	protected int speed;// 상속시 사용가능
	final int TEMP = 0;//변경 불가능
	
	public void running() {
		speed += 5;
		System.out.println("현재 속도: "+speed);
	}
	
	public final void stop() { //오버라이드 불가능
		speed = 0;
		System.out.println("정지");
	}
}
