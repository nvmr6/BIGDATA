package com.lec.ex07_timer;

import java.util.TimerTask;

public class TimerTaskEx1 extends TimerTask{
	//오버라이드 함수에 작업정의
	@Override
	public void run() {
		System.out.println("$$$$$작업1: 2초 후에 한번 예정");
	}
	
}
