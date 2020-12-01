package com.lec.question;

import java.util.Scanner;

public class Q4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("나이를 입력하세요: ");
		int i = sc.nextInt();
		
		System.out.println((i>=65)? "경로우대" : "일반");
		sc.close();
	}
}
