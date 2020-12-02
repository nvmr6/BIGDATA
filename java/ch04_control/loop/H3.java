package com.lec.loop;

import java.util.Scanner;

public class H3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int you,computer;
		while(true){
			System.out.println("가위(0), 바위(1), 보(2)중 하나를 내세요. (종료: -1): ");
			you = sc.nextInt();
			if(you==-1) {
					break;
			}
			
			computer = (int)(Math.random()*3); //1보다 작은 난수 실수 발생
			if(you > 2 || you <-1) {
				System.out.println("다시 내주세요.");
			}else if((you+2)%3==computer) {
				System.out.println("당신이 이겼습니다.");
			}else if((you+1)%3==computer) {
				System.out.println("컴퓨터가 이겼습니다.");
			}else {
				System.out.println("비겼습니다.");
			}
		}
		sc.close();
		System.out.println("게임을 종료합니다.");
	}
}
