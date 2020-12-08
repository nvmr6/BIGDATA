package com.lec.ex05;

public class Circle extends Shape {
	private int r;
	public Circle() {}
	public Circle(int r) {
		this.r = r;
	}
	
	@Override
	public double computeArea() {
		//System.out.println("원의 널이는 "+(3.14*r*r));
		return 3.14*r*r;
	}
	@Override
	public void draw() {
		System.out.println("원");
		super.draw();
	}
}
