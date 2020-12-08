package com.lec.ex05;

public class Triangle extends Shape {
	private int w, h;
	public Triangle() {}
	public Triangle(int w, int h) {
		this.w = w;
		this.h = h;
	}
	@Override
	public double computeArea() {
		//System.out.println("삼각형의 넓이는: "+(0.5*w*h));
		return 0.5*w*h;
	}
	@Override
	public void draw() {
		System.out.println("삼각형");
		super.draw();
	}

}
