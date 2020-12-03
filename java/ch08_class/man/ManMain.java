package com.lec.man;

public class ManMain {
	public static void main(String[] args) {
		Man kim = new Man(20,170,60,"010-9999-9999");
		Man lee = new Man(20,170,60);
		Man jung = new Man(20,"010-9999-9999"); //배열로 생성도 가능하다.
		lee.setTel("010-8894-2154");
		jung.setHeight(180);
		jung.setWeight(70);
		double biman = kim.calculateBMI();
		if(biman>24){
			System.out.println("조심");
		}else {
			System.out.println("정상");
		}
		biman = lee.calculateBMI();
		System.out.println(biman>24? "조심":"정상");
		biman = jung.calculateBMI();
		System.out.println(biman>24? "조심":"정상");
	}
}
