package com.lec.ex09_robot;

public class TestMain {
	public static void main(String[] args) {
		Dance dr = new Dance();
		Draw drr = new Draw();
		Sing sr = new Sing();
		RobotOrder order = new RobotOrder();
		
		order.action(dr); //객체 타입에 따른 메소드 사용
		order.action(drr);
		order.action(sr);
	}
}
