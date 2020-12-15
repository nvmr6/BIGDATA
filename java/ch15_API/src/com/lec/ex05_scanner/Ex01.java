package com.lec.ex05_scanner;

import java.util.Scanner;

public class Ex01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("나이 입력: ");
		int age = sc.nextInt();//30\n > buffer
		System.out.println("입력한 나이: "+age);//n
		System.out.print("이름을 입력: ");
		String name = sc.next();// \n"홍길동"\n, white space 앞까지
		System.out.println("입력하신 이름: "+name);
		System.out.print("주소 입력: ");
		sc.nextLine(); //\n 버퍼 지우기 
		String address = sc.nextLine();//white space 앞까지가 아닌 \n전까지
		System.out.println("입력하신 주소: "+address);
		System.out.println("======================================================");
		sc.close();
	}
}
