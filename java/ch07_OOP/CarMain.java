package com.lec.ex;

public class CarMain {
	public static void main(String[] args) {
		car myPorche = new car(); //car�� Ŭ������ myPorche�� ��ü(�޼���� ������ ����)
		car yourPorche = new car();
		
		myPorche.drive();
		yourPorche.drive();
		
		myPorche.park();
		yourPorche.park();
		
		myPorche.race();
		yourPorche.race();
		
		myPorche.setColor("red"); //myPorche.color = "red";
		yourPorche.setColor("yellow");
		
		System.out.println("���� ������ ����: "+myPorche.getColor());
		System.out.println("���� ������ ����: "+yourPorche.getColor());
		
		System.out.println("���� ������ ��ⷮ: "+myPorche.getCc());
		System.out.println("���� ������ ��ⷮ: "+yourPorche.getCc());
	}
}
