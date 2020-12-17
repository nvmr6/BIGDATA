package com.lec.ex1_list;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex05_Customer {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String ans, name, phone, address;
		ArrayList<Customer> customers = new ArrayList<Customer>(); // Customer[] cs = new Customer[10] > 이전까지는 인덱스 추가가 불가능
		do {
			System.out.println("회원가입을 진행하시겠습니까? (Y/N)");
			ans = sc.next();
			if(ans.equalsIgnoreCase("y")) {
				System.out.print("이름: ");
				name = sc.next();
				System.out.print("전화번호: ");
				phone = sc.next();
				System.out.print("주소: ");
				address = sc.next();
				
				customers.add(new Customer(name,phone,address)); //추가 
			}else if(ans.equalsIgnoreCase("n")) {
				break;
			}
		}while(true);// y,n이 아닌동안 계속 반복
		System.out.println("가입한 회원 리스트 목록");
		for(Customer temp: customers) {
			System.out.println(temp);
		}
		sc.close();
	}
}
