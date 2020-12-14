package com.lec.ex01_string;

import java.util.Scanner;
// I: 대출되었슨니다. /O: 대출되었습니다. /E: 종료
public class Ex04Quiz {
	public static void main(String[] args) {
		String temp;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("대출: O 반납: I 종료: E" );
			temp = sc.next();
			if(temp.equalsIgnoreCase("i")){ //대소문자 구분 없이
				System.out.println("반납");
			}else if(temp.equalsIgnoreCase("o")) {
				System.out.println("대출");
			}
		}while(!temp.equalsIgnoreCase("e")); //같지 않은동안 반복
		System.out.println("시스템 종료");
		//while사용시 while(true) 이용, equalsIgnoreCase("e") > break; 로 빠져나옴
		sc.close();
	}
}
