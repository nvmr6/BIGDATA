package com.lec.condition;

import java.util.Scanner;

public class Ex03_if {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("첫번째 수를 입력하세요: ");
		int num1 = sc.nextInt();
		System.out.println("두번째 수를 입력하세요: ");
		int num2 = sc.nextInt();
		
		if(num1>num2) {
			System.out.println("첫번째 입력한 값이 더 큽니다.");
			System.out.println("최대값: "+num1);
		}else if(num1<num2) {
			System.out.println("두번째 입력한 값이 더 큽니다.");
			System.out.println("최대값: "+num2);
		}else {
			System.out.println("두 값은 같습니다.");
		}
		sc.close();
	}
}
