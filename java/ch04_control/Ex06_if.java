package com.lec.condition;

import java.util.Scanner;

public class Ex06_if {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("����(0), ����(1), ��(2)�� �ϳ��� ������: ");
		
		int you = sc.nextInt();
		
		if(you==0) {
			System.out.println("");
		}else if(you==1) {
			System.out.println("");
		}else if(you==2){
			System.out.println("");
		}else {
			System.out.println("��ȿ���� �ʽ��ϴ�.");
			System.exit(0);
		}
		sc.close();
		
		int computer = (int)(Math.random()*3); //1���� ���� ���� �Ǽ� �߻�
		
		if((you+2)%3==computer) {
			System.out.println("����� �̰���ϴ�.");
		}else if((you+1)%3==computer) {
			System.out.println("��ǻ�Ͱ� �̰���ϴ�.");
		}else {
			System.out.println("�����ϴ�.");
		}
	}
}
