package com.lec.ex;

public class Arithmetic {

	public int sum(int from, int to) {
		int result = 0;
		for(int i=from;i<=to;i++) {
			result += i;
		}
		return result;
	}
	
	public int sum(int to) {//�ٿ뼺
		int result = 0;
		for(int i=1;i<=to;i++) {
			result += i;
		}
		return result;
	}
	
	public String evenodd(int value) {
		String result = value%2==0 ? "¦��":"Ȧ��";
		return result;
	}
	
	public static int abs(int value) { //static�̸� ��ü �������� ��� ����
		int result;
		if(value>=0) {
			result=value;
		}else {
			result = -value;
		}
		return result;
	}
	
}

	