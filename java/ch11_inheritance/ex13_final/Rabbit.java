package com.lec.ex13_final;

public class Rabbit extends Animal{
	@Override
	public void running() {
		speed += 30;
		System.out.println("현재 속도: "+speed);
	}
}
