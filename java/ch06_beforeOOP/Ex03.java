package com.lec.ex;

public class Ex03 {
	public static void main(String[] args) {
		int su = -5;
		System.out.println(Arithmetic.abs(su));
		
		Arithmetic ar = new Arithmetic(); //Arithmetic형 객체 / static이면 객체 생성없이 사용
		int sum = ar.sum(10,51);
		System.out.println("합은"+sum);
		System.out.println(ar.evenodd(sum));
		
		sum = ar.sum(50);
		System.out.println(ar.evenodd(sum));
	}
}
