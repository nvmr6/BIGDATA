package com.lec.question;

import java.util.Scanner;

public class Q2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("������ �Է��ϼ���: ");
		int i = sc.nextInt();
		
		System.out.println((i%2==0)? "¦���Դϴ�." : "Ȧ���Դϴ�.");
		sc.close();
	}
}
