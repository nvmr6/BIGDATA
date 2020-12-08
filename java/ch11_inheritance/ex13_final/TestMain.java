package com.lec.ex13_final;

public class TestMain {
	public static void main(String[] args) {
		Animal animal = new Animal();
		animal.running();
		animal.running();
		animal.stop();
		Dog dog = new Dog();
		dog.running();
		dog.stop();
		Animal dog2 = new Dog(); //상속
		dog2.running();
		dog2.stop();
		//dog2.method(); method함수는 Dog에만 있고 Animal에는 존재하지 않는다
		Object dog3 = new Dog();
	}
}
