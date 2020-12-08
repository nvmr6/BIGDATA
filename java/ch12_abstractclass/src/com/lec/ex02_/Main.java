package com.lec.ex02_;

public class Main {
	public static void main(String[] args) {
		// Super s = new Super; 추상클래스는 객체 생성 불가능
		Child c1 = new Child();
		c1.method1();
		c1.method2();
		c1.method3();
		Super c2 = new Child();
		c2.method1();
		c2.method2();
		//c2.method3(); Super단에는 method3가 존재하지 않는다.
	}
}
