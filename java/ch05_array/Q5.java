package com.lec.ex;

public class Q5 {
	public static void main(String[] args) {
		int[] coinUtil = {500, 100, 50, 10};
		int money = 2680;
		int[] changes = new int[4];
		
		for(int i=0;i<coinUtil.length;i++) {
			changes[i] = (int)(money /coinUtil[i]); //���� ���� ����
			money = money%coinUtil[i]; //�������� ���� �Ž������� �Ի� ���
		}
		for(int i=0;i<changes.length;i++) {
			System.out.println(coinUtil[i]+"��¥��\t"+changes[i]+"��");//�迭�� ����
		}
	}
}
