package com.lec.ex01_string;

import java.util.Scanner;

public class Ex05_search {
	public static void main(String[] args) {
		String[] tels = {"010-4569-7892", "010-3216-7845", "010-2542-8736"};
		Scanner scanner = new Scanner(System.in);
		String searchTel;
		int idx;//전화번호 중복이 없을 때
		
		System.out.println("고객님의 전화번호 뒷자리를 말해주세요.");
		searchTel = scanner.next();
		for(idx=0;idx<tels.length;idx++) {
			String temp = tels[idx];
			String post = temp.substring((temp.lastIndexOf("-")+1));
			if(searchTel.equals(post)) {
				System.out.println(temp);
				break;
			}//if
		}//for
		if(tels.length == idx) {
			System.out.println("입력하신 전화번호는 없는 번호입니다.");
		}
		scanner.close();
	}//main
}
