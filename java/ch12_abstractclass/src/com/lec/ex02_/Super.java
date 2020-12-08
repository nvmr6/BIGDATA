package com.lec.ex02_;

public abstract class Super { //추상 클래스는 객체를 생성할 수 없다.
	public Super() {} //디폴트 생성자
	public abstract void method1(); //1개 이상의 추상 메소드
	public void method2() {
		System.out.println("method2");
	}
}
