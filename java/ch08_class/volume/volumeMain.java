package com.lec.volume;

public class volumeMain {
	public static void main(String[] args) {
		Volume box = new Volume(10,20,30);
		Volume rect = new Volume(10,20);
		
		box.calNsetVolume();
		rect.calNsetVolume();
		
		System.out.println("박스의 부피: " + box.getVolume());
		System.out.println("직사각형의 넓이: " + box.getArea());
	}
}
