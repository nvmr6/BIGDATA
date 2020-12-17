package com.lec.ex3_set;

import java.util.HashSet;
import java.util.Iterator;

public class Ex04_StudentSet {
	public static void main(String[] args) {
		HashSet<Student> students = new HashSet<Student>();//Student형 객체
		Student s = new Student("이순신",6);
		students.add(s);
		students.add(s); // 중복 불가능
		System.out.println(students);
		students.add(new Student("홍길동", 6));
		students.add(new Student("장보고", 6));
		students.add(new Student("장보고", 6)); //new 를 통해 추가시 중복 > set이 아님
		System.out.println(students);
		
		Iterator<Student> iter = students.iterator(); //반복자 생성
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
	}
}
