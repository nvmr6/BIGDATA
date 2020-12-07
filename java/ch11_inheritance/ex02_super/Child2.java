package com.lec.ex02_super;

public class Child2 extends SuperIJ2 {
	private int total;
	public Child2(int i, int j) {
		//this.i = i; private이여서 불가능, protected면 가능
		setI(i);
		setJ(j);
	}
	public void sum() {
		//total에 i+j 핟당
		//total = i+j // private이면 접근 불가능
		total = getI()+getJ();
		System.out.println(total);
	}
}
