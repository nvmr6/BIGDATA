package com.lec.condition;

public class Ex07_switch {
	public static void main(String[] args) {
		int num = (int)(Math.random()*6);
		
		switch(num) {
		case 1:
			System.out.println("주사위: 1");break;
		case 2:
			System.out.println("주사위: 2");break;
		case 3:
			System.out.println("주사위: 3");break;
		case 4:
			System.out.println("주사위: 4");break;
		case 5:
			System.out.println("주사위: 5");break;
		case 6:
			System.out.println("주사위: 6");break;
		default:
			System.out.println("그 외");break;
		}
	}
}
