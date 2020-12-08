package com.lec.ex05;

public abstract class Shape {
	public void draw() {
		System.out.println("DRAW");
	}
	public abstract double computeArea(); //추상, 넚이 return
}
