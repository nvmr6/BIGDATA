package com.lec.ex01_string;
//various String function
public class Ex02 {
	public static void main(String[] args) {
		String str1 = "abcXabc";
		String str2 = new String("abcXabc");
		String str3 = "  ja  va  ";
		System.out.println("1. concat: "+str1.concat(str2)); //String 붙이기
		System.out.println("2. subString: "+str1.substring(3));//3번째부터 끝까지
		System.out.println("3. subString: "+str1.substring(3,5));//3번째부터 5번째 앞까지
		System.out.println("4. length: "+str1.length());//3번째부터 5번째 앞까지
		System.out.println("5. toUpperCase: "+str1.toUpperCase());//대문자
		System.out.println("6. toLowerCase: "+str2.toLowerCase());//소문자
		System.out.println("7. charAt: "+str1.charAt(3));//3번째 문자 하나
		System.out.println("8. indexOf: "+str1.indexOf("b"));//첫 b가 있는 인덱스
		System.out.println("9. indexOf: "+str1.indexOf("b",3));//3번째 이후로 b가 있는 인덱스
		System.out.println("10. lastIndexOf: "+str1.lastIndexOf("b"));//마지막 b가 있는 인덱스
		System.out.println("11. lastIndexOf: "+str1.lastIndexOf("d"));//없으면 -1 리턴
		System.out.println("12. equals: "+str1.equals(str2));//같은지 여부
		System.out.println("13. equalsIgnoreCase: "+str1.equalsIgnoreCase(str2));//대소문자 구분없이 같은지
		System.out.println("14. trim: "+str3.trim());//좌우 스페이스 제거
		System.out.println("15. replace: "+str1.replace('a','w'));//문자 대치
		System.out.println("15. replace: "+str1.replace("ab","dq"));//문자열 대치
	}
}
