package com.lec.ex4_threadNobjectN;

public class ThreadEx2TestMain {
	public static void main(String[] args) {
		Thread t1 = new ThreadEx2(); //t1 run 수행
		t1.setName("A");
		Thread t2 = new ThreadEx2();
		t2.setName("B");
		//num을 공유하지 않는다
		t1.start();
		t2.start();
	}
}
