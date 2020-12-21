package com.lec.ex1_runnable;

public class TargetExTestMain {
	public static void main(String[] args) {
		Runnable t1 = new TargetEx01();
		Runnable t2 = new TargetEx02();
		
		Thread threadA = new Thread(t1,"A");//A라는 이름의 thread 생성, target01 안의 run 수행하는 thread
		Thread threadB = new Thread(t2,"B");//B라는 이름의 thread 생성, target02 안의 run 수행하는 thread
		
		threadA.start();
		threadB.start();
		
		for(int i=0;i<10;i++) {
			System.out.println("Main Thread "+Thread.currentThread().getName());
			try {
				Thread.sleep(500);//대기
			} catch (InterruptedException e) {}
		}
	}
}
