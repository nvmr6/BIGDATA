package com.lec.ex11_store;

public class Main2 {
	public static void main(String[] args) {
		HeadQuarterStore[] store = {new HeadQuarterStore("=====본사====="),
									new storeNum1("=====1호점====="),
									new storeNum2("=====2호점====="),
									new storeNum3("=====3호점=====")}; //HeadQuarterStore가 될 수 있다
		
//		for(int i=0;i<store.length;i++) {
//			System.out.println(store[i].getName());
//			store[i].kimchi();
//			store[i].bood();
//			store[i].bibim();
//			store[i].soon();
//			store[i].kong();
//		}
		
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
