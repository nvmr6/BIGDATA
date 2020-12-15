package com.lec.ex03_math;

import java.util.Random;

public class Ex03_Random {
	public static void main(String[] args) {
		System.out.println((int)(Math.random()*10)+1); //1~10사이 랜덤수
		
		Random random = new Random();
		System.out.println("int난수: "+random.nextInt());//정수 난수
		System.out.println("0~100까지 난수: "+(random.nextInt(100)+1));//101전까지
		System.out.println("double난수: "+random.nextDouble());//0~1이내의 난수
		System.out.println("true / false: "+ random.nextBoolean());//참거짓 난수
	}
}	
