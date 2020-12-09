package com.lec.ex02_store;

public class Main {
	public static void main(String[] args) {
		HeadQuarterStore[] store = {new storeNum1("=====1호점====="),
									new storeNum2("=====2호점====="),
									new storeNum3("=====3호점=====")};

		for(HeadQuarterStore s : store) {
			System.out.println(s.getName());
			s.kimchi();
			s.bood();
			s.bibim();
			s.soon();
			s.kong();
		}
	}
}