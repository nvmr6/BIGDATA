package com.lec.ex;
//import com.lec.ex.Arithmetic; 타패키지에서 선언시 import 필요


public class Ex04 {
	public static void main(String[] args) {
		//Ex04 ex = new Ex04(); //static이 없으면 객체 생성 후 사용
		printCh();
		System.out.println("Hello");
		printCh('#');
		System.out.println("Hello");
		printCh('$',30);
	}
	private static void printCh() { //static이 없으면 객체 필요
		for(int cnt=1;cnt<=20;cnt++) {
			System.out.print("*");
		}
		System.out.println("");
	}
	private static void printCh(char ch) {
		for(int cnt=1;cnt<=20;cnt++) {
			System.out.print(ch);
		}
		System.out.println("");
	}
	private static void printCh(char ch, int num) { //static이 없으면 객체 필요
		for(int cnt=1;cnt<=num;cnt++) {
			System.out.print(ch);
		}
		System.out.println("");
	}
}
