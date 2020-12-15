package com.lec.ex05_scanner;

import java.util.Scanner;

//next > nextLine > nextLine
//nextLine > next
public class Ex02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("address: ");
		String address = sc.nextLine();// buffer 청소
		System.out.println("address is "+address);
		System.out.println("name: ");
		String name = sc.nextLine();// buffer 청소
		System.out.println("name is "+name);
		System.out.println("age: ");
		int age = sc.nextInt();
		System.out.println("age is "+age);
		sc.close();
	}
}
