package com.lec.ex1_list;

import java.util.Vector;

public class Ex04_Vector {
	public static void main(String[] args) {
		Vector<Object> vec = new Vector<Object>();//~형 데이터만 들어간다.
		AClass objA = new AClass();
		BClass objB = new BClass();
		
		vec.add(objA); //0번 인덱스
		vec.add(objB); //1번 인덱스
		vec.add("C"); //2번 인덱스
		vec.add(10); //3번 인덱스
		for(int i=0;i<vec.size();i++) {
			System.out.println(vec.get(i));
		}
		if(vec.isEmpty()) {
			System.out.println("empty");
		}else {
			System.out.println("not empty");
		}
	}
}
