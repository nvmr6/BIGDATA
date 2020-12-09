package com.lec.ex07_toy;

public class TestMain {
	public static void main(String[] args) {
		IToy[] toys = {new BearToy(), new RobotToy(), new AirplaneToy()};
		
		for(IToy temp: toys) {
			System.out.println(temp.getClass().getName());
			System.out.println(temp);//toString 생략
			System.out.println("=================================");
		}
	}
}
