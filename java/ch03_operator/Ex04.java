package com.lec.ex;

public class Ex04 {
	public static void main(String[] args) {
		//논리연산자: &&, and, ||, or
		int i =1, j = 10, h = 10;
		System.out.println("&&(AND): (i<j) && (++j>h)은 " + ((i<j) && (++j>h)));
		System.out.println("j="+j);
		
		System.out.println("&&(AND): (i>j) && (++j>h)은 " + ((i>j) && (++j>h)));
		System.out.println("j="+j); // and는 false일 경우 우항은 실행하지 않는다.
		
		System.out.println("||(OR): (i>j) || (++j>h)은 " + ((i<j) || (++j>h)));
		System.out.println("j="+j); // or는 true일 경우 우항은 실행하지 않는다.
	}
}
