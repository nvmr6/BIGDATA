package com.lec.ex;

public class Ex01 {
	public static void main(String[] args) {
		//��� ������
		int n1 = 33, n2 = 10;
		int result;
		double resultDouble;
		
		result = n1 + n2;
		System.out.printf("%d %c %d = %d\n\n",  n1, '+', n2, result);
		result = n1 - n2;
		System.out.printf("%d %c %d = %d\n\n",  n1, '-', n2, result);
		result = n1 * n2;
		System.out.printf("%d %c %d = %d\n\n",  n1, '*', n2, result);
		
		resultDouble = (double)n1 / n2; //����� ����ȯ 4����Ʈ > 8����Ʈ
		System.out.printf("%d %c %d = %.1f\n\n",  n1, '/', n2, resultDouble);
		result = n1 % n2;
		System.out.printf("%d %c %d = %d\n\n",  n1, '%', n2, result);
		
		//������ �������� ���ӻ�
		if((n1%2)==0)
			System.out.println("¦��");
		else
			System.out.println("Ȧ��");
	}
}
