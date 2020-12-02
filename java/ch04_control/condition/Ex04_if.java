package com.lec.condition;

import java.util.Scanner;

public class Ex04_if {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("첫번째 수를 입력하세요: ");
		int num = sc.nextInt();
		
		if(num>=0) {
			System.out.println("입력한 값의 절대값: "+num);
		}
		else {
			System.out.println("입력한 값의 절대값: "+(-num));
		}
		sc.close();
	}
}
