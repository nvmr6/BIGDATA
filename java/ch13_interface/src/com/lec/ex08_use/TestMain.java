package com.lec.ex08_use;

public class TestMain {
	public static void main(String[] args) {
		User user = new User();
		A a = new A();
		B b = new B();
		user.aorbUse(a);
		user.aorbUse(b); //객체의 부품화(같은 타입)
	}
}
