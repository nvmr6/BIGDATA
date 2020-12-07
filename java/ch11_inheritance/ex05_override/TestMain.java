package com.lec.ex05_override;

public class TestMain {
	public static void main(String[] args) {
		ParentClass Pobj1 = new ParentClass();
		ParentClass Pobj2 = new ParentClass(2);
		
		Pobj1.method1();
		Pobj1.method2();
		System.out.println("");
		ChildClass Cobj1 = new ChildClass();
		ChildClass Cobj2 = new ChildClass(2);
		Cobj1.method1(); //재정의
		Cobj1.method2(); //재정의 없음
		Cobj1.method3(); //child 메소드
	}
}
