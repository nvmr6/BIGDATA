package com.lec.ex;

public class Ex02 {
	public static void main(String[] args) {
		//증감연산자 ++, --
		int n1 = 10; //10
		
		/*++n1; // 11 즉시 연산
		n1++; // 11 다음 시점에서 연산
		*/
		
		int n2 = n1++; //연산
		//n2 = 10, n1 = 11
		System.out.printf("1. n1 = %d,  n2 = %d\n", n1, n2);
		int n3 = 10;
		System.out.printf("2. n3++ = %d\n", n3++);
		System.out.printf("3. n3 = %d \n", n3);
		
		int temp = 10;
		System.out.printf("4. %d %d %d %d \n", temp++, ++temp, temp--, --temp);
	}
}
