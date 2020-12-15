package com.lec.ex07_timer;

import java.util.Timer;

public class TimerMain {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("start");
		Timer timer = new Timer(true); //true넣어야 종료 가능
		TimerTaskEx1 task1 = new TimerTaskEx1();//작업 정의
		TimerTaskEx2 task2 = new TimerTaskEx2();//작업 정의
		timer.schedule(task1, 2000);//2000ms후에 한번 실행
		timer.schedule(task2, 1000, 1000);//1000ms후에 1000ms마다 실행
		Thread.sleep(100000);// 10초 대기
		System.out.println("end");
	}
}
