package com.lec.ex01;
//interfaceEx01(CONSTANT_NUM, method1())
//interfaceEx02(CONSTANT_STRING, method2())
public class InterfaceClass implements InterfaceEx01, InterfaceEx02{
	@Override
	public void method1() {
		System.out.println("실제 구현은 클래스에서");
	}
	@Override
	public String method2() {
		System.out.println("실제 구현은 클래스에서");
		return "=";
	}
}
