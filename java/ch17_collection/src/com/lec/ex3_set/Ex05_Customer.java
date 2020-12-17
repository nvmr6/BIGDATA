package com.lec.ex3_set;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

import com.lec.ex1_list.Customer;

public class Ex05_Customer {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String ans, name, phone, address;
		HashMap<String, Customer> customers = new HashMap<String,Customer>(); // Customer[] cs = new Customer[10] > 이전까지는 인덱스 추가가 불가능
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
				customers.put(phone, new Customer(name, phone, address));
			}else if(ans.equalsIgnoreCase("n")) {
				break;
			}
		}while(true);// y,n이 아닌동안 계속 반복
		sc.close();
		if(customers.isEmpty()) {
			System.out.println("가입한 회원 목록이 없습니다.");
		}else {
			System.out.println("가입한 회원 리스트 목록");
			Iterator<String> iter = customers.keySet().iterator(); //반복자 생성
			while(iter.hasNext()) {
				String key = iter.next();
				System.out.println(customers.get(key));
			}
		}
	}
}
