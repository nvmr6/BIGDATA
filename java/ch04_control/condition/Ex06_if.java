package com.lec.condition;

import java.util.Scanner;

public class Ex06_if {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("가위(0), 바위(1), 보(2)중 하나를 내세요: ");
		
		int you = sc.nextInt();
		
		if(you==0) {
			System.out.println("");
		}else if(you==1) {
			System.out.println("");
		}else if(you==2){
			System.out.println("");
		}else {
			System.out.println("유효하지 않습니다.");
			System.exit(0);
		}
		sc.close();
		
		int computer = (int)(Math.random()*3); //1보다 작은 난수 실수 발생
		
		if((you+2)%3==computer) {
			System.out.println("당신이 이겼습니다.");
		}else if((you+1)%3==computer) {
			System.out.println("컴퓨터가 이겼습니다.");
		}else {
			System.out.println("비겼습니다.");
		}
	}
}
