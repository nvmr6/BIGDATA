package com.lec.ex0;

class PersonInfo{ //Ŭ���� ������ ���� ���Ͽ� �Բ� �ۼ��ϴ� ���� ���� ��
	private String name;
	private int age;
	private char gender;
	public PersonInfo() {}//������ �����ε�
	public PersonInfo(String name, int age, char gender) {
		this.name = name;
		this.age = age;
		this.gender = gender;
	}
	public void print() {
		System.out.println("�̸� = "+name+"\t���� = "+age+"\t����= "+gender);
	}
	public String infoString() {
		String result = "�̸� = "+name+"\t���� = "+age+"\t����= "+gender;
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
		PersonInfo p = new PersonInfo("ȫ�浿", 24, 'M');
		p.print();
		System.out.println(p.infoString());
		System.out.println("");
		
		PersonInfo [] person = {new PersonInfo("���ö", 25, 'M'),
								new PersonInfo("�����", 25 , 'F'),
								new PersonInfo()}; //��ü �迭 Ȱ��
		person[2].setName("������");
		person[2].setAge(25);
		person[2].setGender('F');
		
		for(PersonInfo temp: person) { //��¸� �Ҷ� Ȯ�� for�� ���
			temp.print();
			System.out.println(temp.infoString());
		}
	}
}
