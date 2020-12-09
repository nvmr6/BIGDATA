package com.lec.ex05;

public class TestChildClass extends TestClass implements I11{ //다중 상속 (클래스와 인터페이스)

	@Override
	public void m11() {
		System.out.println("상수 i11은 "+I11.i11);
	}
	
}
