package com.lec.ex05_override;

public class ParentClass {
	//생성자 2개: 생성자 함수의 오버로딩(함수의 중복 정의)
	public ParentClass() {
		System.out.println("매개변수 없는 생성자");
	}
	public ParentClass(int i) {
		System.out.println("매개변수 있는 생성자");
	}
	public void method1() {
		System.out.println("Parent의 method1");
	}
	public void method2() {
		System.out.println("Parent의 method2");
	}
	public void method2(int i) {
		System.out.println("Parent의 method2");
	}//메소드도 오버로딩 가능, 리턴 타입은 같아야 한다
	
}
