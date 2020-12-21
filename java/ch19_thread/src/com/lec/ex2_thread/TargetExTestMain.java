package com.lec.ex2_thread;

public class TargetExTestMain {
	public static void main(String[] args) {
		Thread target01 = new TargetEx01();//thread생성 target01.run 수행
		target01.setName("A"); //thread 이름 
		Thread target02 = new TargetEx02();
		target02.setName("B");
		
		target01.start();
		target02.start();
		
		for(int i=0;i<10;i++) {
			System.out.println("Main Thread");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {}
		}
	}
}
