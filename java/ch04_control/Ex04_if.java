package com.lec.condition;

import java.util.Scanner;

public class Ex04_if {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("ù��° ���� �Է��ϼ���: ");
		int num = sc.nextInt();
		
		if(num>=0) {
			System.out.println("�Է��� ���� ���밪: "+num);
		}
		else {
			System.out.println("�Է��� ���� ���밪: "+(-num));
		}
		sc.close();
	}
}
