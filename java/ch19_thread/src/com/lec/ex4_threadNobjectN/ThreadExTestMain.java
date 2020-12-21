package com.lec.ex4_threadNobjectN;
//thread n개가 작업객체 N개 공유 (Runnable)
public class ThreadExTestMain {
	public static void main(String[] args) {
		Runnable target1 = new ThreadEx();
		Runnable target2 = new ThreadEx();
		
		Thread t1 = new Thread(target1,"A");
		Thread t2 = new Thread(target2,"B");

		t1.start();
		t2.start();
	}
	
	
}
