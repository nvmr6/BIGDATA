package com.lec.question;

import java.util.Scanner;

public class Q3 {
	public static void main(String[] args) {
		Scanner sc1 = new Scanner(System.in);
		System.out.print("������ �Է��ϼ���: ");
		int num1 = sc1.nextInt();
		
		Scanner sc2 = new Scanner(System.in);
		System.out.print("������ �Է��ϼ���: ");
		int num2 = sc2.nextInt();
		
		System.out.println((num1==num2)? "�����ϴ�." : "�ٸ��ϴ�.");
		System.out.println((num1>num2)? "num1�� Ů�ϴ�." : "num2�� Ů�ϴ�.");
		
		sc1.close();
		sc2.close();
	}
}
