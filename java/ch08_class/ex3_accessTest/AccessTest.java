package com.lec.ex3_accessTest;

public class AccessTest {
	private int privatemember; //같은 클래스 내부
	int defaultmember; //같은 패키지 내부
	protected int protectedmember;//같은 패키지,상속받은 하위 클래스 내부
	public int publicmember;//모든 클래스 내부
	
	private void privatemethod() {
		System.out.println("private method");
		}
	void defaultmethod() {
		System.out.println("default method");
		}
	protected void protectedmethod() {
		System.out.println("protected method");
		}
	public void publicmethod() {
		System.out.println("public method");
		}
	
}
