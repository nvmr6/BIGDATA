package com.lec.ex;

public class Ex02 {
	
	public static void main(String[] args) {
		Arithmetic ar = new Arithmetic();
		int tot = ar.sum(1,10);
		System.out.println(tot);
		System.out.println(ar.evenodd(tot));
		
		tot = ar.sum(100);
		System.out.println(tot);
		System.out.println(ar.evenodd(tot));
		
		tot = ar.sum(10,51);
		System.out.println(tot);
		System.out.println(ar.evenodd(tot));
	}
}
