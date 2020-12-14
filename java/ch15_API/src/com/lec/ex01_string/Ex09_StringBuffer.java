package com.lec.ex01_string;

public class Ex09_StringBuffer {
	public static void main(String[] args) {
		StringBuilder strBuilder = new StringBuilder("abc");
		System.out.println("1. "+strBuilder);
		strBuilder.append("def"); // concat과 유사
		System.out.println("2. "+strBuilder);
		strBuilder.insert(3, "AAA"); //3번 인덱스에 추가
		System.out.println("3. "+strBuilder);
		strBuilder.delete(3, 6); //3번부터 6번 앞까지 삭제
		System.out.println("4. "+strBuilder);
		int capacitySize = strBuilder.capacity(); //가용크기
		System.out.println("가용크기: "+capacitySize);
		System.out.println("현재 해쉬코드: "+strBuilder.hashCode());
		strBuilder.append("987654321987654321"); //객체를 또 만드는 것이 아닌 가용크기 자동으로 확장
		capacitySize = strBuilder.capacity();
		System.out.println("가용크기: "+capacitySize);
		System.out.println("현재 해쉬코드: "+strBuilder.hashCode());
		strBuilder.ensureCapacity(1000);//가용크기 확장
		capacitySize = strBuilder.capacity();
		System.out.println("가용크기: "+capacitySize);
		System.out.println("현재 해쉬코드: "+strBuilder.hashCode());
	}
}
