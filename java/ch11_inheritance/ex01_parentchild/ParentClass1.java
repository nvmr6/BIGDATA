package com.lec.ex01_parentchild;
//상속해준 클래스 Parent Class / Super Class
public class ParentClass1 {
	String pStr = "부모 클래스";
	public ParentClass1() {
		System.out.println("부모 클래스 객체 부분 생성");
		
	}
	public void getPapaname() {
		System.out.println("아빠이름: 홍길동");
	}
	public void getMamaname() {
		System.out.println("엄마이름: 김길순");
	}
}
