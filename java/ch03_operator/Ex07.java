package com.lec.ex;

public class Ex07 {
	public static void main(String[] args) {
		//비트연산자: |, &
		int n1 = 10, n2 =5;
		int result1 = n1 & n2; // 1010 & 0101 = 0000 > 0
		System.out.println("n1 & n2 ="+result1);
		
		int result2 = n1 | n2; // 1010 | 0101 = 1111 > 15
		System.out.println("n1 | n2 ="+result2);
	}
}
