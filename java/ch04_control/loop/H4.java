package com.lec.loop;

import java.util.Scanner;

public class H4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int you,computer;
		while(true){
			System.out.println("가위(0), 바위(1), 보(2)중 하나를 내세요: ");
			you = sc.nextInt();
			
			computer = (int)(Math.random()*3); 
			if(you > 2 || you < 0) {
				System.out.println("다시 내주세요.");
			}else if(you==computer) {
				System.out.println("비겼습니다.");
			}else if((you+1)%3==computer) {
				System.out.println("패배했습니다.");
			}else {
				break;
			}
		}
		sc.close();
		System.out.println("당신이 승리하였습니다. 게임을 종료합니다.");
	}
}
