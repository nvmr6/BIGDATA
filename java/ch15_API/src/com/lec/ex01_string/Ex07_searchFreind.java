package com.lec.ex01_string;

import java.util.Scanner;

public class Ex07_searchFreind {
	public static void main(String[] args) {
		
	
	Friend[] friends = {new Friend("홍길동", "010-7899-4566", "12-7"),
					    new Friend("김길동", "010-4566-7899", "12-8"),
					    new Friend("이길동", "010-1233-7899", "12-9")};
	//찾을 친구의 전화번홍 뒷자리 입력
	//해당 전화번호 뒷자리와 같은 친구가 있으면 그 친구 출력 없으면 없다고 출력
	Scanner sc = new Scanner(System.in);
	System.out.println("전화번호 뒷자리 입력");
	String searchTel = sc.next();
	int idx;
	boolean searchOk = false;
	for(idx=0;idx<friends.length;idx++) {
		String temp = friends[idx].getTel();
		String post = temp.substring((temp.lastIndexOf("-")+1));
		if(post.equals(searchTel)) {
			System.out.println(friends[idx]);// toString호출
//			friends[idx].print();
			searchOk = true; //중복 없음
			break; //중복 있음
		}//if
	}//for
	if(!searchOk) {
		System.out.println("입력하신 전화번호는 없는 번호입니다.");
	}
	sc.close();
	}
}
