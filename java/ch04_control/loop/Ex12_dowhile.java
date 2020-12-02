package com.lec.loop;

import java.util.Scanner;

public class Ex12_dowhile {
	public static void main(String[] args) {
		int num;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("짝수를 입력하세요: ");
			num = sc.nextInt(); //do-while밖에서도 쓰도록 밖에서 선언
		}while(num%2==1); //홀수인동안 do반복  
		System.out.println("입력하신 짝수는 "+num);
		sc.close();
	}
}

