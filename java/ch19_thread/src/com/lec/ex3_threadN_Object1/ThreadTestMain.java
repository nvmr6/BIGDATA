package com.lec.ex3_threadN_Object1;
//thread n개가 작업객체 1개 공유 (Runnable)
public class ThreadTestMain {
	public static void main(String[] args) {
		ThreadEx target = new ThreadEx();//작업객체 1개를 공유
		Thread t1 = new Thread(target,"A");
		Thread t2 = new Thread(target,"B");
		t1.start();
		t2.start(); //A가 증가시킨 num 공유
		System.out.println("end");
	}
}
