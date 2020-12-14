package com.lec.ex01_string;

public class Ex10_speedCheck {
	public static void main(String[] args) {
		String str = "A";
		long start = System.currentTimeMillis();
		for(int i=0;i<300000;i++) {
			str = str.concat("a");
		}
		long end = System.currentTimeMillis();
		System.out.println(end-start);
		
		StringBuffer strBuf = new StringBuffer("A");
		start = System.currentTimeMillis();
		for(int i=0;i<300000;i++) {
			strBuf.append("a");
		}
		end = System.currentTimeMillis();
		System.out.println(end-start);
		
		StringBuilder strBui = new StringBuilder("A");
		start = System.currentTimeMillis();
		for(int i=0;i<300000;i++) {
			strBui.append("a");
		}
		end = System.currentTimeMillis();
		System.out.println(end-start);
	}
}
