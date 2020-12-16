package com.lec.ex1_tryCatch;

import java.util.Scanner;

public class Ex02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int i,j;
		System.out.println("첫번째 수는 ");
		i = sc.nextInt();
		System.out.println("두번째 수는 ");
		j = sc.nextInt();
		System.out.println("i = "+i+"j = "+j);
		System.out.println("i+j="+(i+j));
		System.out.println("i-j="+(i-j));
		System.out.println("i*j="+(i*j));
		try {
		System.out.println("i/j="+(i/j)); // i=10, j=0 > 오류발생
		}catch(ArithmeticException e) {
			System.out.println(e.getMessage());// 오류 발생시 대처, 예외 메세지만
			e.printStackTrace(); //예외사항을 자세히 출력
		}
		System.out.println("Done.");
		sc.close();
	}
}
