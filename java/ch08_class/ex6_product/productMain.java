package com.lec.ex6_product;

public class productMain {
	public static void main(String[] args) {
		Product p1 = new Product();
		p1.infoString();
		Product p2 = new Product();
		p2.infoString();
		Product p3 = new Product();
		p3.infoString();
		System.out.println("static변수: "+Product.count); //static변수는 클래스로 접근
		//System.out.println("static변수: "+p1.count);//가능하지만 객체로 접근하는 것은 좋지 않다.
	}
}
