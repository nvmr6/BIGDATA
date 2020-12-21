package com.lec.ex1_runnable;

public class TargetTestMain {
	public static void main(String[] args) {
		Target target = new Target();
		
		Thread t1 = new Thread(target,"A");
		Thread t2 = new Thread(target,"B");// 같은 target 두번 생성
		
		t1.start();
		t2.start();
		System.out.println(Thread.currentThread().getName());
		System.out.println("end");
	}
}
