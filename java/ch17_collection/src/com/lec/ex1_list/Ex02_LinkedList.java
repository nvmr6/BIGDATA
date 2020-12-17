package com.lec.ex1_list;

import java.util.LinkedList;

public class Ex02_LinkedList {
	public static void main(String[] args) {
		LinkedList<String> linkedList = new LinkedList<String>(); //동일 자료형만 넣는다
		linkedList.add("str0");
		linkedList.add("str1");
		linkedList.add("str2"); //서로 주소 링크
		linkedList.add(1, "str"); // 작업이 따로 없이 링크 연결, 적은 구동시간
		System.out.println(linkedList);
		for(int i=0;i<linkedList.size();i++) {
			System.out.println(linkedList.get(i));
		}
		linkedList.clear();
		System.out.println(linkedList.isEmpty()? "empty":"not empty");
	}
}
