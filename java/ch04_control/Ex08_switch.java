package com.lec.condition;

import java.util.Scanner;

public class Ex08_switch {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("������ �Է��ϼ���: ");
		int score = sc.nextInt();
		
//		if(100 < score) { // if������ �ذ�
//			System.out.println("��ȿ���� �ʽ��ϴ�.");
//		}else if(90 < score) {
//			System.out.println("A�����Դϴ�.");
//		}else if(80 < score) {
//			System.out.println("B�����Դϴ�.");
//		}else if(70 < score) {
//			System.out.println("C�����Դϴ�.");
//		}else if(60 < score) {
//			System.out.println("D�����Դϴ�.");
//		}else {
//			System.out.println("F�����Դϴ�.");
//		}
		sc.close();
		
		int temp = score==100? score-1:score; // 100���� ��� ��ó
		switch(temp/10) {
		case 9:
			System.out.println("A�����Դϴ�.");break;
		case 8:
			System.out.println("B�����Դϴ�.");break;
		case 7:
			System.out.println("C�����Դϴ�.");break;
		case 6:
			System.out.println("D�����Դϴ�.");break;
		case 5: case 4: case 3: case 2: case 1:
			System.out.println("D�����Դϴ�.");break;
		default:
			System.out.println("��ȿ���� �ʽ��ϴ�.");
		}
			
	}
}
