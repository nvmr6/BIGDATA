package com.lec.loop;

import java.util.Scanner;

public class Ex12_dowhile {
	public static void main(String[] args) {
		int num;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("¦���� �Է��ϼ���: ");
			num = sc.nextInt(); //do-while�ۿ����� ������ �ۿ��� ����
		}while(num%2==1); //Ȧ���ε��� do�ݺ�  
		System.out.println("�Է��Ͻ� ¦���� "+num);
		sc.close();
	}
}

