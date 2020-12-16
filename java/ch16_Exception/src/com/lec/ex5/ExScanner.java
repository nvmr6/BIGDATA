package com.lec.ex5;

import java.util.Scanner;

public class ExScanner {
	public static void main(String[] args) {
		//이름, 나이, 별명
		Scanner sc = new Scanner(System.in);
		System.out.println("입력: ");
		String name = sc.next();
		System.out.println("이름: "+name);
		nickName();
		System.out.println("입력: ");
		int age = sc.nextInt();
		System.out.println("나이: "+age);
		sc.close();
	}
	private static void nickName() {
		Scanner sc = new Scanner(System.in);
		System.out.println("입력: ");
		String nickName = sc.next();
		System.out.println("별명: "+nickName);
		//sc.close(); 호출한 곳은 스캐너를 닫지 않는다
	}
}
