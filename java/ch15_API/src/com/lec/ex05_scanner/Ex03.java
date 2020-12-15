package com.lec.ex05_scanner;

import java.util.Scanner;

public class Ex03 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String you;
		int computer;
		while(true){
			System.out.println("가위, 바위, 보 중에 하나를 내주세요: ");
			you = sc.nextLine().trim();
			int temp = 0;
			switch(you) {
			case "가위":
				temp = 0; break;
			case "바위":
				temp = 1; break;
			case "보":
				temp = 2; break;
			}
			computer = (int)(Math.random()*3); 
			if(temp==computer) {
				System.out.println("비겼습니다.");
			}else if((temp+1)%3==computer) {
				System.out.println("패배했습니다.");
			}else {
				break;
			}
		}
		sc.close();
		System.out.println("승리했습니다. 시스템을 종료합니다.");
	}
}
