package com.lec.loop;

public class Ex02_for {
	public static void main(String[] args) {
		//1~20 ������ ���
		int tot = 0;
//		for(int i=1;i<=20;i++) {
//			// tot�� ����
//			tot+=i;
//		}
		for(int i=1;i<=20;i++) {
			System.out.print(i);
			tot+=i;
			if(i!=20){
				System.out.print("+");
			}else {
				System.out.print("=");
			}
		}
		System.out.println(tot);
	}
}
