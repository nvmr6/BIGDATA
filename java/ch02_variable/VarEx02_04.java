package com.lec.ex;

public class VarEx02_04 {
	public static void main(String[] args) {
		//변수 선언 방법
		
		//1. 자료형 변수명 ;
		int num1; //선언
		num1 = 3; //초기화
		System.out.println("num1 = "+num1);
		
		//2. 자료형 변수명 = 값;
		char c1 = '가'; //선언과 동시에 초기화
		System.out.println("c1 = "+c1);
		
		//3. 자료형 변수명1, 변수명2;
		boolean b1, b2, b3;
		b1 = true; b2 = false; b3 = false;
		System.out.print("b1 = "+b1+"\t b2 = "+b2+"\t b1 ="+b3+"\n"); //자동 개행 없음

		//4. 자료형 변수명1=값1, 변수명2=값2 ...
		long l1 = 2200000000l;
		float f1 = 1.1f, f2 = 2.2f, f3 = 0.22f;
		System.out.println("f1 ="+f1+"\t f2 ="+f2+"\t f3 ="+f3);
		System.out.printf("f1 = %3.1f f2 = %3.1f \n", f1, f2);
		//%f: 실수	%d: 정수		%c: 문자		%s: 문자열		%x: 16진수
		
		System.out.println("end"); //자동 개행
	}
}
