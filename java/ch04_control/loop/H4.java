package com.lec.loop;

import java.util.Scanner;

public class H4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int you,computer;
		while(true){
			System.out.println("����(0), ����(1), ��(2)�� �ϳ��� ������: ");
			you = sc.nextInt();
			
			computer = (int)(Math.random()*3); 
			if(you > 2 || you < 0) {
				System.out.println("�ٽ� ���ּ���.");
			}else if(you==computer) {
				System.out.println("�����ϴ�.");
			}else if((you+1)%3==computer) {
				System.out.println("�й��߽��ϴ�.");
			}else {
				break;
			}
		}
		sc.close();
		System.out.println("����� �¸��Ͽ����ϴ�. ������ �����մϴ�.");
	}
}
