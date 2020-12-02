package com.lec.condition;

import java.util.Scanner;

public class Ex09_switch {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("월을 입력하세요: ");
		int month = sc.nextInt();

		sc.close();
		
		switch(month) {
		case 12: case 1: case 2:
			System.out.println("겨울입니다.");break;
		case 3: case 4: case 5:
			System.out.println("가을입니다.");break;
		case 6: case 7: case 8:
			System.out.println("여름입니다.");break;
		case 9: case 10: case 11:
			System.out.println("봄입니다.");break;
		default:
			System.out.println("유효하지 않습니다.");
		}
			
	}
}
