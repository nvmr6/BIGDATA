package com.lec.condition;

public class Ex02_if {
	public static void main(String[] args) {
		int seoulLunchPrice = 7000;
		if(seoulLunchPrice>7000) {
			System.out.println("��γ�");
		}else if(seoulLunchPrice >= 6000) {
			System.out.println("�׳ɱ׷���");
		}else if(seoulLunchPrice >=4000) {
			System.out.println("������");
		}else {
			System.out.println("�����ϳ�");
		}
	}
}
