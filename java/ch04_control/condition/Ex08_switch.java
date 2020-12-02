package com.lec.condition;

import java.util.Scanner;

public class Ex08_switch {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("점수를 입력하세요: ");
		int score = sc.nextInt();
		
//		if(100 < score) { // if문으로 해결
//			System.out.println("유효하지 않습니다.");
//		}else if(90 < score) {
//			System.out.println("A학점입니다.");
//		}else if(80 < score) {
//			System.out.println("B학점입니다.");
//		}else if(70 < score) {
//			System.out.println("C학점입니다.");
//		}else if(60 < score) {
//			System.out.println("D학점입니다.");
//		}else {
//			System.out.println("F학점입니다.");
//		}
		sc.close();
		
		int temp = score==100? score-1:score; // 100점일 경우 대처
		switch(temp/10) {
		case 9:
			System.out.println("A학점입니다.");break;
		case 8:
			System.out.println("B학점입니다.");break;
		case 7:
			System.out.println("C학점입니다.");break;
		case 6:
			System.out.println("D학점입니다.");break;
		case 5: case 4: case 3: case 2: case 1:
			System.out.println("D학점입니다.");break;
		default:
			System.out.println("유효하지 않습니다.");
		}
			
	}
}
