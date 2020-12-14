package com.lec.ex01_string;

import java.util.Scanner;
//뒷자리 중복이 있을 경우
public class Ex06_search2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] tels = {"010-4569-7892", "010-3216-7845", "010-2542-8736"};
		System.out.println("고객님의 전화번호 뒷자리를 말해주세요.");
		String searchTel = scanner.next();
		boolean searchOk = false;
		for(int idx=0;idx<tels.length;idx++) {
			String temp = tels[idx];
			String post = temp.substring((temp.lastIndexOf("-")+1));
			if(searchTel.equals(post)) {
				System.out.println(temp);
				searchOk = true;
			}//if
		}//for
		if(!searchOk) {
			System.out.println("입력하신 전화번호는 없는 번호입니다.");
		}
		scanner.close();
	}//main
}
