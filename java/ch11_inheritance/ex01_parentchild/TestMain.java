package com.lec.ex01_parentchild;

public class TestMain {
	public static void main(String[] args) {
		ChildClass1 child = new ChildClass1();
		child.getPapaname();
		child.getMamaname();
		System.out.println(child.pStr);
		System.out.println(child.cStr);
	}
}
