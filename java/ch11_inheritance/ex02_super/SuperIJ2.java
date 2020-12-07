package com.lec.ex02_super;

public class SuperIJ2 {
	private int i;
	private int j;
	public SuperIJ2() {
		System.out.println("매개변수 없는 것");
	}
	public SuperIJ2(int i, int j) {
		this.i = i;
		this.j = j;
		System.out.println("매개변수 있는 것");
	}
	public int getI() {
		return i;
	}
	public void setI(int i) {
		this.i = i;
	}
	public int getJ() {
		return j;
	}
	public void setJ(int j) {
		this.j = j;
	}
	
}
