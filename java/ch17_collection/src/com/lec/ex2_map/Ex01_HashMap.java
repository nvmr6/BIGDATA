package com.lec.ex2_map;

import java.util.HashMap;
import java.util.Iterator;

public class Ex01_HashMap {
	public static void main(String[] args) {
		String[] strArr = new String[5];
		
		HashMap<Integer, String> hashMap = new HashMap<Integer, String>(); //key , value
		hashMap.put(11,"str11");
		hashMap.put(22, "str22");
		hashMap.put(33, "str33"); //key값 중복 불가능
		System.out.println(hashMap.get(22)); //key값으로 호출
		System.out.println("remove 전"+hashMap);
		hashMap.remove(11);
		System.out.println("remove 후"+hashMap);// 순서없음
		hashMap.clear();
		
		hashMap.put(0, "Hong Gildong");
		hashMap.put(1, "Kim Dongil");
		hashMap.put(2, "Lee Soonsin");
		hashMap.put(3, "Jung Yakyong");
		
		Iterator<Integer> iter = hashMap.keySet().iterator(); //반복자 생성
		while(iter.hasNext()) {
			Integer key = iter.next();
			System.out.println(key+"의 데이터는 "+hashMap.get(key));
		}
	}
}
