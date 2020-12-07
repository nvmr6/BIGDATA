package com.lec.ex01_parentchild;
//상속받는 클래스 Child Class, 자손 클래스
public class ChildClass1 extends ParentClass1{ //같은 패키지내 상속, import 없음
	String cStr = "아들 클래스";
	public ChildClass1() {
		System.out.println("자식 클래스 객체 부분 생성");
	}
}
