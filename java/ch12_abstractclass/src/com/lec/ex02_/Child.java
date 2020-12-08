package com.lec.ex02_;

public class Child extends Super {

	@Override
	public void method1() {
		System.out.println("method override");
	}//반드시 오버라이드
	
	public void method3() {
		System.out.println("method3");
	}
}
