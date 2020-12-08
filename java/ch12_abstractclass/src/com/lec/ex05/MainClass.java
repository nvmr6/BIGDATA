package com.lec.ex05;

public class MainClass {
	public static void main(String[] args) {
		Shape[] shape = {new Circle(5),
						 new Rectangle(10,5),
						 new Triangle(10,5)
		};
		
		for(Shape s: shape) {
			s.draw();
			System.out.println("도형의 넓이는 "+s.computeArea());
		}
	}
}
