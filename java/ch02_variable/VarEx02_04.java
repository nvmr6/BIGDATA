package com.lec.ex;

public class VarEx02_04 {
	public static void main(String[] args) {
		//���� ���� ���
		
		//1. �ڷ��� ������ ;
		int num1; //����
		num1 = 3; //�ʱ�ȭ
		System.out.println("num1 = "+num1);
		
		//2. �ڷ��� ������ = ��;
		char c1 = '��'; //����� ���ÿ� �ʱ�ȭ
		System.out.println("c1 = "+c1);
		
		//3. �ڷ��� ������1, ������2;
		boolean b1, b2, b3;
		b1 = true; b2 = false; b3 = false;
		System.out.print("b1 = "+b1+"\t b2 = "+b2+"\t b1 ="+b3+"\n"); //�ڵ� ���� ����

		//4. �ڷ��� ������1=��1, ������2=��2 ...
		long l1 = 2200000000l;
		float f1 = 1.1f, f2 = 2.2f, f3 = 0.22f;
		System.out.println("f1 ="+f1+"\t f2 ="+f2+"\t f3 ="+f3);
		System.out.printf("f1 = %3.1f f2 = %3.1f \n", f1, f2);
		//%f: �Ǽ�	%d: ����		%c: ����		%s: ���ڿ�		%x: 16����
		
		System.out.println("end"); //�ڵ� ����
	}
}
