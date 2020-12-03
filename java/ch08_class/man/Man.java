package com.lec.man;
//man kim = new Man(20,170,60,"010-9999-9999");
//man lee = new Man(20,170,60);
//man jung = new Man(20,"010-9999-9999");

public class Man {
	private int age;
	private int height;
	private int weight;
	private String tel;
	
	public Man() {} //디폴트 생성자
	public Man(int age, int height, int weight, String tel) {
		this.age = age;
		this.height = height;
		this.weight = weight;
		this.tel = tel;
	}
	public Man(int age, int height, int weight) {
		this.age = age;
		this.height = height;
		this.weight = weight;
	}
	public Man(int age, String tel) {
		this.age = age;
		this.tel = tel;
	}
	
	public double calculateBMI() { //메소드
		double result = weight / ((height*0.1)*(height*0.1)); 
		return result;
	}
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		 this.age =age;
	}
	public int getHeight() {
		return height;
	}
	
	public void setHeight(int height) {
		 this.height =height;
	}
	public int getWeight() {
		return weight;
	}
	
	public void setWeight(int weight) {
		 this.weight =weight;
	}
	public String getTel() {
		return tel;
	}
	
	public void setTel(String tel) {
		 this.tel =tel;
	}
}
