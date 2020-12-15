package com.lec.ex06_wrapper;
//가변인자함수
public class Ex02 {
	public static void main(String[] args) {
		int total = valueSum("10", "20", "30", "40");
		System.out.println("들어온 값의 합계: "+total);
	}
	private static int valueSum(String ... value) {//매개변수의 수 상관없이(단 모두 String)
		int result = 0; //누적 변수
		for(int i=0;i<value.length;i++){
			result += Integer.parseInt(value[i]);// val문자열을 정수로 바꿔준다.
		}
		return result;
	}
}
