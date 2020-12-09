package com.lec.ex05;

public class TestClass implements I3{

	@Override
	public void m1() {
		System.out.println("상수 i1은 "+I1.i1);
	}

	@Override
	public void m2() {
		System.out.println("상수 i2은 "+I2.i2);
	}

	@Override
	public void m3() {
		System.out.println("상수 i3은 "+I3.i3);
	}

}
