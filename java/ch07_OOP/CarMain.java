package com.lec.ex;

public class CarMain {
	public static void main(String[] args) {
		car myPorche = new car(); //car가 클래스고 myPorche가 객체(메서드와 변수를 갖음)
		car yourPorche = new car();
		
		myPorche.drive();
		yourPorche.drive();
		
		myPorche.park();
		yourPorche.park();
		
		myPorche.race();
		yourPorche.race();
		
		myPorche.setColor("red"); //myPorche.color = "red";
		yourPorche.setColor("yellow");
		
		System.out.println("나의 포르쉐 색상: "+myPorche.getColor());
		System.out.println("나의 포르쉐 색상: "+yourPorche.getColor());
		
		System.out.println("나의 포르쉐 배기량: "+myPorche.getCc());
		System.out.println("나의 포르쉐 배기량: "+yourPorche.getCc());
	}
}
