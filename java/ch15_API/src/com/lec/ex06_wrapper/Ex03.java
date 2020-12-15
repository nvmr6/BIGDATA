package com.lec.ex06_wrapper;
//스트링 > 정수 / 정수 > 스트링
public class Ex03 {
	public static void main(String[] args) {
		System.out.println("스트링에서 정수: Integer.pasreInt(문자열)");
		int i = Integer.parseInt("123");
		System.out.println(i);
		
		System.out.println("정수에서 스트링: String.valueOf(정수)");
		//String monthString = ""+12
		String monthString = String.valueOf(12);
		System.out.println(monthString);
	}
}
