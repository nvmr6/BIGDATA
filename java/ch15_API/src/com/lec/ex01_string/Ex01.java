package com.lec.ex01_string;

public class Ex01 {
	public static void main(String[] args) {
		String str1 = "java";
		String str2 = "java";
		String str3 = new String("java");
		
		if(str1==str2) {//이미 만들어진 string에 같은 주소 부여
			System.out.println("same address");
		}else {
			System.out.println("different address");
		}
		
		str1 = "java2";
		
		if(str1==str2) {//이미 만들어진 string에 같은 주소 부여
			System.out.println("same address");
		}else {
			System.out.println("different address");
		}
		
		if(str1==str3) {//무조건 새로운 주소 부여
			System.out.println("same address");
		}else {
			System.out.println("different address");
		}
		
		System.out.println(str1.hashCode()); //해쉬코드 출력
		System.out.println((str2.equals(str3))? "same":"different");//같은 스트링인지
	}
}
