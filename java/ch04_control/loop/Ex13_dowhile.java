package com.lec.loop;

import java.util.Scanner;

public class Ex13_dowhile {
	public static void main(String[] args) {
		int lotto,num,min=1,max=45; //범위 지정
		lotto = (int)(Math.random()*45)+1;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.printf("%d ~ %d 사이의 수를 입력하세요: ",min,max); //반복시 범위 안내
			num = sc.nextInt();
			if(num<min || num>max) { //범위 밖의 수 입력
				System.out.printf("범위를 확인하세요");
			}else if(num<lotto) {
				min = num + 1; //최소범위 증가
			}else if(num>lotto) {
				max = num - 1; //최대범위 감소
			}else {
				break; //당첨
			}
		}while(lotto != num);
		System.out.println("당첨입니다.");
		sc.close();
	}
}
