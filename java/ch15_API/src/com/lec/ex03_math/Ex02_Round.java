package com.lec.ex03_math;

public class Ex02_Round {
	public static void main(String[] args) {
		System.out.println("소수점에서 반올림");
		System.out.println("9.12를 올림"+Math.ceil(9.12));
		System.out.println("9.12를 반올림"+Math.round(9.12));
		System.out.println("9.12를 내림"+Math.floor(9.12));
		
		System.out.println("\n소숫점 한자리에서 반올림");
		System.out.println("9.15를 올림"+Math.ceil(9.15*10)/10);
		System.out.println("9.15를 반올림"+Math.round(9.15*10)/10.0);// 리턴 타입이 정수이기 때문
		System.out.println("9.15를 내림"+Math.floor(9.15*10)/10);
		
		System.out.println("\n일의 자리에서 반올림");
		System.out.println("11를 올림"+Math.ceil(11/10.0)*10);
		System.out.println("19를 반올림"+Math.round(19/10.0)*10.0);
		System.out.println("19를 내림"+Math.floor(19/10.0)*10);
	}
}
