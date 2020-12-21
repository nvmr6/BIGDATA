package com.lec.ex5_synchronize;

public class ThreadEx implements Runnable{
	private int num; //공유 변수
	@Override
	public void run() {//run 수행중에 간섭 불가능
		for(int i=0;i<10;i++) {
			out();
			}
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {}
		}
	private synchronized void out() {
		String threadName = Thread.currentThread().getName();
		if(threadName.equals("A")) {
			System.out.println("A process");
			num++;
		}
		System.out.println(threadName+"의 num: "+num);
	}
}
