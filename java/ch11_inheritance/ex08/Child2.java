package com.lec.ex08;

public class Child2 extends Parent {
	private int c2 = 2;
	public Child2() {
		System.out.println("Child2형 객체 생성");
	}
	public int getC2() {
		return c2;
	}
	public void setC2(int c2) {
		this.c2 = c2;
	}
	
}
