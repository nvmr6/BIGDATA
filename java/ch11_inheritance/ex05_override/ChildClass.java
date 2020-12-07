package com.lec.ex05_override;

public class ChildClass extends ParentClass {
	public ChildClass() {
		System.out.println("C매개변수 없는 생성자");
	}
	public ChildClass(int i) {
		System.out.println("C매개변수 있는 생성자");
	}
	
	public void method1() {// 더 넓은 접근 제한자와 같은 리턴 타입
		System.out.println("Child의 method1");
	}//메소드 재정의, 오버라이딩
	public void method3() {
		System.out.println("Child의 method3");
	}
}
