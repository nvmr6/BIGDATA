package com.lec.ex3_set;

public class Student {
	private String name;
	private int grade;
	public Student(String name, int grade) {
		this.name = name;
		this.grade = grade;
	}
	@Override
	public String toString() {
		return name+":"+grade;
	}
	
	@Override
	public boolean equals(Object obj) { //같은 문자열 중복 방지
		if(this==obj) {
			return true;
		}
		if(obj!=null && obj instanceof Student) {
			boolean nameChk = name.equals(((Student)obj).name);
			boolean gradeChk = grade == (((Student)obj).grade);
			return nameChk && gradeChk;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return toString().hashCode(); // 결과 문자열의 해쉬코드 출력 
	}
}
