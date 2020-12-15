package com.lec.ex06_wrapper;

public class Ex01 {
	public static void main(String[] args) {
		int i = 10;
		int j = 10;
		if(i==j) {
			System.out.println("same");
		}else{
			System.out.println("diff");
		}//변수
		Integer obj1 = new Integer(10);
		Integer obj2 = new Integer(10);
		if(obj1.equals(obj2)) { //주소는 다르고 데이터는 같다.
			System.out.println("same");
		}else{
			System.out.println("diff");
		}//객체의 주소
		
		if("hello".equals(new Integer(10))) { //10과 같다, 자동변환
			System.out.println("same");
		}else{
			System.out.println("diff");
		}
		int total = obj1 + obj2; //연산도 가능하다.
	}
}
