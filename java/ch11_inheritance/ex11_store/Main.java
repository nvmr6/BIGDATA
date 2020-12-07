package com.lec.ex11_store;

public class Main {
	public static void main(String[] args) {
		HeadQuarterStore st = new HeadQuarterStore("=====본사=====");
		System.out.println(st.getName());
		st.kimchi();
		st.bood();
		st.bibim();
		st.soon();
		st.kong();
		
		HeadQuarterStore st1 = new storeNum1("=====1호점=====");
		System.out.println(st1.getName());
		st1.kimchi();
		st1.bood();
		st1.bibim();
		st1.soon();
		st1.kong();
		
		HeadQuarterStore st2= new storeNum2("=====2호점=====");
		System.out.println(st2.getName());
		st2.kimchi();
		st2.bood();
		st2.bibim();
		st2.soon();
		st2.kong();
		
		HeadQuarterStore st3 = new storeNum3("=====3호점=====");
		System.out.println(st3.getName());
		st3.kimchi();
		st3.bood();
		st3.bibim();
		st3.soon();
		st3.kong();
	}
}
