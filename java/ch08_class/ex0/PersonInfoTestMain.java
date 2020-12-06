package com.lec.ex0;

class PersonInfo{ //클래스 파일을 메인 파일에 함께 작성하는 좋지 않은 예
	private String name;
	private int age;
	private char gender;
	public PersonInfo() {}//생성자 오버로딩
	public PersonInfo(String name, int age, char gender) {
		this.name = name;
		this.age = age;
		this.gender = gender;
	}
	public void print() {
		System.out.println("이름 = "+name+"\t나이 = "+age+"\t성별= "+gender);
	}
	public String infoString() {
		String result = "이름 = "+name+"\t나이 = "+age+"\t성별= "+gender;
		return result;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getAge() {
		return age;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public char getGender() {
		return gender;
	}
	
	
}
public class PersonInfoTestMain {
	public static void main(String[] args) {
		PersonInfo p = new PersonInfo("홍길동", 24, 'M');
		p.print();
		System.out.println(p.infoString());
		System.out.println("");
		
		PersonInfo [] person = {new PersonInfo("김민철", 25, 'M'),
								new PersonInfo("김민지", 25 , 'F'),
								new PersonInfo()}; //객체 배열 활용
		person[2].setName("이지수");
		person[2].setAge(25);
		person[2].setGender('F');
		
		for(PersonInfo temp: person) { //출력만 할땐 확장 for문 사용
			temp.print();
			System.out.println(temp.infoString());
		}
	}
}
