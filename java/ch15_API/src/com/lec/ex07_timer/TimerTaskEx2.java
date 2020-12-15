package com.lec.ex07_timer;

import java.util.TimerTask;

public class TimerTaskEx2 extends TimerTask{
	//오버라이드 함수에 작업정의
	@Override
	public void run() {
		System.out.println("%%%%%작업2: 1초마다 수행 예정");
	}
	
}
