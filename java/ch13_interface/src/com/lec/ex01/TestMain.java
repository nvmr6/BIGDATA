package com.lec.ex01;

public class TestMain {
	public static void main(String[] args) {
		//인터페이스에는 추상메소드가 존재해서 객체를 생성할 수 없다.
		InterfaceClass obj = new InterfaceClass();
		obj.method1();
		obj.method2();
		InterfaceEx01 obj1 = new InterfaceClass();
		obj1.method1();
		//obj1.method2(); obj1의 변수는 InterfaceEx01이여서 method2가 존재하지 않는다.
		InterfaceEx02 obj2 = new InterfaceClass();
		//obj2.method1(); obj2의 변수는 InterfaceEx01이여서 method1가 존재하지 않는다.
		obj2.method2();
	}
}
