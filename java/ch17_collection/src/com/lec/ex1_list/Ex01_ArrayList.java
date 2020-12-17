package com.lec.ex1_list;

import java.util.ArrayList;

public class Ex01_ArrayList {
	public static void main(String[] args) {
		String[] array = new String[3];
		array[0] = "str0";
		array[1] = "str1";
		array[2] = "str2";
		for(int i=0;i<array.length;i++) {
			System.out.println(array[i]);
		}
		
		ArrayList<String> arrayList = new ArrayList<String>();//int 불가능, 객체만 만들 수 있다, 동일 자료형만 넣는다
		arrayList.add("str0"); //자동으로 메모리를 잡고 0번 인덱스에 들어감
		arrayList.add("str1"); //1번 인덱스
		arrayList.add("str2"); //2번 인덱스
		for(int i=0;i<arrayList.size();i++) {//size로 해야한다
			System.out.println(arrayList.get(i));//다른 for문
		}
		
		arrayList.add(1, "str"); // 중간에 끼어넣으면 인덱스가 자동으로 밀림
		for(String temp: arrayList) {
			System.out.println(temp);
		}
		
		arrayList.remove(1); //인덱스 제거
		System.out.println(arrayList);
		
		arrayList.clear();//모든 데이터 삭제
		System.out.println(arrayList);
		
		if(arrayList.isEmpty()) {
			System.out.println("Empty");
		}
		arrayList = null; //주소 자체가 사라짐 > 비울때는 clear 사용
	}
}
