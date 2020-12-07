package com.lec.ex;

import com.acom.ex.Emp;//타패키지 임포트

public class TestMain {
	public static void main(String[] args) {
		Emp emp = new Emp(101);
		com.bcom.ex.Emp emp1 = new com.bcom.ex.Emp();// bcom import,같은 이름의 타패키지 사용시 전체 클래스 이름 사용
		emp.getNo();
		emp1.getI();
	}
}
