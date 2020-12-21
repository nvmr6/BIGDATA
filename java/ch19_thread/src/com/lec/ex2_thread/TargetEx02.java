package com.lec.ex2_thread;

public class TargetEx02 extends Thread{
	@Override
	public void run() {
		for(int i=0;i<10;i++) {
			System.out.println("Hey "+Thread.currentThread().getName());
			try {
				Thread.sleep(500);//대기
			} catch (InterruptedException e) {}
		}
	}
}
