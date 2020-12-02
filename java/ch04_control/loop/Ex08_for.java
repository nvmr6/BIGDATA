package com.lec.loop;

import java.util.Scanner;

public class Ex08_for {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("몇 단을 출력할까요: ");
		int num =sc.nextInt();
		
		for(int i=1;i<=9;i++) {
			System.out.printf("%d x %d = %d\n",num,i,i*num);
		}
		sc.close();
	}
}
