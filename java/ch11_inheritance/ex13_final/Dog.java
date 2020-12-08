package com.lec.ex13_final;

public final class Dog extends Animal { //상속 불가능
	@Override
	public void running() {
		speed += 10;
		System.out.println("현재속도: "+speed);
	}
	public void method() {
		System.out.println("method");
	}
	//stop 오버라이드 불가능
}
