package com.lec.ex1_tryCatch;

import java.util.Scanner;

public class Ex01 {
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
		System.out.println("i/j="+(i/j)); // i=10, j=0 > 오류발생
		System.out.println("Done.");
		sc.close();
	}
}
