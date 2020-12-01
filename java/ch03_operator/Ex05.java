package com.lec.ex;

public class Ex05 {
	public static void main(String[] args) {
		//삼항 연산자: 참일시 좌항, 거짓일시 우항
		int h = 100;
		String result = (h%2==0)? "짝수":"홀수";
		System.out.println("삼항연산자의 결과는: " + result);
	}
}
