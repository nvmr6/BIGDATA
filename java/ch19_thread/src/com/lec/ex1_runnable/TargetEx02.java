package com.lec.ex1_runnable;

public class TargetEx02 implements Runnable{

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
