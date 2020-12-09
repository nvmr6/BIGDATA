package com.lec.ex09_robot;

public class RobotOrder {
	public void action(Robot r) {//로봇에 따라 명령
		if(r instanceof Dance) {//객체타입을 물어본다.
			((Dance)r).dance();//형변환후 메소드 실행
		}else if(r instanceof Sing) {
			((Sing)r).sing();
		}else if(r instanceof Draw) {
			((Draw)r).draw();
		}else {
			System.out.println("실행할 수 없습니다.");
		}
	}
}
