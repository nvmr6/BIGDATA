package com.lec.man;

public class ManMain {
	public static void main(String[] args) {
		Man kim = new Man(20,170,60,"010-9999-9999");
		Man lee = new Man(20,170,60);
		Man jung = new Man(20,"010-9999-9999"); //�迭�� ������ �����ϴ�.
		lee.setTel("010-8894-2154");
		jung.setHeight(180);
		jung.setWeight(70);
		double biman = kim.calculateBMI();
		if(biman>24){
			System.out.println("����");
		}else {
			System.out.println("����");
		}
		biman = lee.calculateBMI();
		System.out.println(biman>24? "����":"����");
		biman = jung.calculateBMI();
		System.out.println(biman>24? "����":"����");
	}
}
