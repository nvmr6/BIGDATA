package com.lec.ex3_exceptions;

public class Ex1_NullPoint {
	public static void main(String[] args) {
		String greeting = "Hello";
		System.out.println(greeting.toUpperCase());
		greeting = null;
		System.out.println(greeting.toUpperCase()); //null 주소로 갈 수 없다
	}
}
