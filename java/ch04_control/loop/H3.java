package com.lec.loop;

import java.util.Scanner;

public class H3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int you,computer;
		while(true){
			System.out.println("����(0), ����(1), ��(2)�� �ϳ��� ������. (����: -1): ");
			you = sc.nextInt();
			if(you==-1) {
					break;
			}
			
			computer = (int)(Math.random()*3); //1���� ���� ���� �Ǽ� �߻�
			if(you > 2 || you <-1) {
				System.out.println("�ٽ� ���ּ���.");
			}else if((you+2)%3==computer) {
				System.out.println("����� �̰���ϴ�.");
			}else if((you+1)%3==computer) {
				System.out.println("��ǻ�Ͱ� �̰���ϴ�.");
			}else {
				System.out.println("�����ϴ�.");
			}
		}
		sc.close();
		System.out.println("������ �����մϴ�.");
	}
}
