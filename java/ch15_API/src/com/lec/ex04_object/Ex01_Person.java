package com.lec.ex04_object;

public class Ex01_Person {
	public static void main(String[] args) {
		String str1 = "java";
		String str2 = new String("java"); //새로운 주소
		if(str1.equals(str2)) { //주소는 다르고 내부는 같다.
			System.out.println("same");
		}else {
			System.out.println("false");
		}
		
		Person p1 = new Person(9311111111111L);
		Person p2 = new Person(9311111111111L); //다른 객체지만 같은 번호
		if(p1.equals(p2)) { //object의 equals
			System.out.println("같은 person 객체");
		}else {
			System.out.println("다른 person 객체");
		}
	}
}
