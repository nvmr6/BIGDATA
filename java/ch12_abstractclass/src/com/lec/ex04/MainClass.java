package com.lec.ex04;

public class MainClass {
	public static void main(String[] args) {
		Shape[] shape = {new Circle(5),
						 new Rectangle(10,5),
						 new Triangle(10,5)
		};
		
		for(Shape s: shape) {
			s.draw();
			s.computeArea();
		}
	}
}
