package com.lec.question;

import java.util.Scanner;

public class Q3 {
	public static void main(String[] args) {
		Scanner sc1 = new Scanner(System.in);
		System.out.print("정수를 입력하세요: ");
		int num1 = sc1.nextInt();
		
		Scanner sc2 = new Scanner(System.in);
		System.out.print("정수를 입력하세요: ");
		int num2 = sc2.nextInt();
		
		System.out.println((num1==num2)? "같습니다." : "다릅니다.");
		System.out.println((num1>num2)? "num1이 큽니다." : "num2가 큽니다.");
		
		sc1.close();
		sc2.close();
	}
}
