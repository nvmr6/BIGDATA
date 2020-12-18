package com.lec.ex2_DataInputStream;

public class Product {
	private String name;
	private String price;
	private String ps;
	
	public Product(String name, String price, String ps) {
		super();
		this.name = name;
		this.price = price;
		this.ps = ps;
	}

	@Override
	public String toString() {
		return name+"\t"+price+"\t"+ps;
	}
}
