package com.lec.loop;

import java.util.Scanner;

public class Ex13_dowhile {
	public static void main(String[] args) {
		int lotto,num,min=1,max=45; //���� ����
		lotto = (int)(Math.random()*45)+1;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.printf("%d ~ %d ������ ���� �Է��ϼ���: ",min,max); //�ݺ��� ���� �ȳ�
			num = sc.nextInt();
			if(num<min || num>max) { //���� ���� �� �Է�
				System.out.printf("������ Ȯ���ϼ���");
			}else if(num<lotto) {
				min = num + 1; //�ּҹ��� ����
			}else if(num>lotto) {
				max = num - 1; //�ִ���� ����
			}else {
				break; //��÷
			}
		}while(lotto != num);
		System.out.println("��÷�Դϴ�.");
		sc.close();
	}
}
