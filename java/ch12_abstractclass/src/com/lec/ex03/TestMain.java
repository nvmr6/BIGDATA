package com.lec.ex03;

public class TestMain {
	public static void main(String[] args) {
		// SuperClass s = new SuperClass(); 추상으로 불가능
		// ChildClass c = new ChildClass(); 추상으로 불가능
		SuperClass s = new GrandChild();//부모단 가능
		s.method1();
		s.method2();
		//s.method3(); 불가능
		ChildClass c = new GrandChild();//부모단 가능
		c.method1();
		c.method2();
		c.method3();
		GrandChild g = new GrandChild();
		g.method1();
		g.method2();
		g.method3();
	}
}
