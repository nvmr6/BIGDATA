package com.lec.ex3_set;

import java.util.HashSet;
import java.util.Iterator;

public class Ex01_HashSet {
	public static void main(String[] args) {
		HashSet<String> hashSet = new HashSet<String>();
		//"str0","str1","str2","str3","str4", "str5"
		hashSet.add("str0");
		hashSet.add("str1");
		hashSet.add("str2");
		hashSet.add("str3");
		hashSet.add("str2"); //중복 불가능
		System.out.println(hashSet);
		System.out.println(hashSet.size());
		
		Iterator<String> iter = hashSet.iterator(); //반복자 생성
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
	}
}
