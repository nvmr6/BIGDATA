package com.lec.ex;
//import com.lec.ex.Arithmetic; Ÿ��Ű������ ����� import �ʿ�


public class Ex04 {
	public static void main(String[] args) {
		//Ex04 ex = new Ex04(); //static�� ������ ��ü ���� �� ���
		printCh();
		System.out.println("Hello");
		printCh('#');
		System.out.println("Hello");
		printCh('$',30);
	}
	private static void printCh() { //static�� ������ ��ü �ʿ�
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
	private static void printCh(char ch, int num) { //static�� ������ ��ü �ʿ�
		for(int cnt=1;cnt<=num;cnt++) {
			System.out.print(ch);
		}
		System.out.println("");
	}
}
