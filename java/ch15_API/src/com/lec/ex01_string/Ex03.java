package com.lec.ex01_string;

import java.util.Scanner;

public class Ex03 {
	public static void main(String[] args) {
		Ex03 ex = new Ex03();
		System.out.println(ex.getClass().getName());
		//com.lec.ex01_string.Ex03 > Ex03
		String str = ex.getClass().getName();
		System.out.println(str.substring(str.lastIndexOf("E")));
		
		Scanner sc = new Scanner(System.in);
		System.out.println("전화번호는: ");
		String tel = sc.next();
		
		System.out.println("입력한 전화번호: "+tel);
		for(int i=0;i<tel.length();i++) {
			if(i%2==0) {
				System.out.println(tel.charAt(i));
			}else {
				System.out.print(" ");
			}
		}
		System.out.println();
		for(int i=str.length()-1;i>=0;i--) {
			System.out.print(str.charAt(i-1));
		}
		String pre = tel.substring(0,tel.indexOf("-"));
		System.out.println(pre);
//		System.out.println("전화번호 맨 앞자리는 "+tel.substring(0,3));
		String post = tel.substring(tel.lastIndexOf("-")+1);
		System.out.println(post);
//		System.out.println("전화번호 맨 뒷자리는 "+tel.substring(8));
		sc.close();
	}
}
