package com.lec.ex2_map;

import java.util.Hashtable;
import java.util.Iterator;

public class Ex02_HashTable {
	public static void main(String[] args) {
		Hashtable<String, String> hashTable = new Hashtable<String, String>();
		hashTable.put("010-9999-9999", "홍길동");
		hashTable.put("010-8888-8888", "김길동");
		hashTable.put("010-7777-7777", "이길동");
		hashTable.put("010-6666-6666", "최길동");
		System.out.println(hashTable); //키 값 중복 불가능
		
		Iterator<String> iter = hashTable.keySet().iterator(); //반복자 생성
		while(iter.hasNext()) {
			String key = iter.next();
			System.out.println(key+": "+hashTable.get(key));
		}
	}
}
