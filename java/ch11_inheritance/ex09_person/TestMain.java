package com.lec.ex09_person;

public class TestMain {
	public static void main(String[] args) {
		Person papa = new Person("papa", "fat");
		Person mama = new Person("mama", "thin");
		papa.intro();
		mama.intro();
		
		Baby child1 = new Baby();
		child1.setName("baby");
		child1.setCharacter("cute");
		child1.intro(); //오버라이드 됨
		Baby child2 = new Baby("baby", "cute");
		child2.cry();
	}
}
