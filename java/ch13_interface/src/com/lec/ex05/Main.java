package com.lec.ex05;

public class Main {
	public static void main(String[] args) {
		TestChildClass test = new TestChildClass();
		System.out.println(I1.i1);//test로 가능
		System.out.println(I2.i2);//test로 가능
		System.out.println(I3.i3);//test로 가능
		
		test.m1();
		test.m2();
		test.m3();
		test.m11();
		
		TestClass cTest = test;
		cTest.m1();
		cTest.m2();
		cTest.m3();
		// cTest.m11(); childcclass에 있다
	}
}
