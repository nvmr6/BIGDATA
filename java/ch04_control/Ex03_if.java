package com.lec.condition;

import java.util.Scanner;

public class Ex03_if {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("ù��° ���� �Է��ϼ���: ");
		int num1 = sc.nextInt();
		System.out.println("�ι�° ���� �Է��ϼ���: ");
		int num2 = sc.nextInt();
		
		if(num1>num2) {
			System.out.println("ù��° �Է��� ���� �� Ů�ϴ�.");
			System.out.println("�ִ밪: "+num1);
		}else if(num1<num2) {
			System.out.println("�ι�° �Է��� ���� �� Ů�ϴ�.");
			System.out.println("�ִ밪: "+num2);
		}else {
			System.out.println("�� ���� �����ϴ�.");
		}
		sc.close();
	}
}
