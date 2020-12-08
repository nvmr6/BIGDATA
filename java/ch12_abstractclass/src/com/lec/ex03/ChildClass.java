package com.lec.ex03;

public abstract class ChildClass extends SuperClass { //override 혹은 abstract
	//super로부터 받은 추상 메소드 method1()
	@Override
	public void method2() {
		System.out.println("method2"); //재정의
	}
	public void method3() {
		System.out.println("method3");
	}
}
