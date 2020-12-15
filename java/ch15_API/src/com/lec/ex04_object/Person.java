package com.lec.ex04_object;

public class Person {
	private long juminNo;

	public Person(long juminNo) {
		this.juminNo = juminNo;
	}
	@Override
	public boolean equals(Object obj) { //주민번호가 같으면 같다고 나오도록 오버라이드(String처럼 오버라이드)
		//p1.equals(p2) > this-p1, object-p2
		//p1.equals(p3) > false
		//this.juminNo, obj.juminNo 같으면 true return
		if(obj!=null && obj instanceof Person) {//null이 아니고 Person형이어야 한다.
			//juminNo == obj.juminNo 여부 리턴
			return juminNo == ((Person)obj).juminNo;//형변환 
		}//같으면 true
		return false;
	}
}
