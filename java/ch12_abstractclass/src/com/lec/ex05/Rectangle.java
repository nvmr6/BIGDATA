package com.lec.ex05;

public class Rectangle extends Shape {
	private int w, h;
	public Rectangle() {}
	public Rectangle(int w, int h) {
		this.w = w;
		this.h = h;
	}
	@Override
	public double computeArea() {
		//System.out.println("사각형의 넓이는: "+(w*h));
		return w*h;
	}
	@Override
	public void draw() {
		System.out.println("사각형");
		super.draw();
	}

}
