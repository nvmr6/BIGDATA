package com.lec.ex01_string;

public class Ex08 {
	public static void main(String[] args) {
		String str1 = "월드컵"; //String str1 = new String("월드컵);
		String str2 = "월드컵";
		if(str1==str2) {
			System.out.println("same");
		}else {
			System.out.println("diff");
		}
		System.out.println(str1.hashCode());
		System.out.println(str2.hashCode());
		//같은 식별위치
		
		str1 = str1+" 2020";
		System.out.println(str1.hashCode());
		System.out.println(str2.hashCode());
		//다른 식별위치
		if(str1==str2) {
			System.out.println("same");
		}else {
			System.out.println("diff");
		}
		
	}
}
