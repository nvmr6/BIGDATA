package com.lec.ex;

public class Ex04 {
	public static void main(String[] args) {
		//��������: &&, and, ||, or
		int i =1, j = 10, h = 10;
		System.out.println("&&(AND): (i<j) && (++j>h)�� " + ((i<j) && (++j>h)));
		System.out.println("j="+j);
		
		System.out.println("&&(AND): (i>j) && (++j>h)�� " + ((i>j) && (++j>h)));
		System.out.println("j="+j); // and�� false�� ��� ������ �������� �ʴ´�.
		
		System.out.println("||(OR): (i>j) || (++j>h)�� " + ((i<j) || (++j>h)));
		System.out.println("j="+j); // or�� true�� ��� ������ �������� �ʴ´�.
	}
}
