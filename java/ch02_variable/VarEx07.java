package com.lec.ex;

public class VarEx07 {
	public static void main(String[] args){
		int i1 = 10; //4bytes
		long l1 = 10; /*8����Ʈ �ȿ� 4����Ʈ �Ҵ��ϱ� ���� 
						4����Ʈ�� 10�� 8����Ʈ long������ �������� ����ȯ*/
		double d1 = i1; //�������� ����ȯ
		
		//������� ����ȯ
		d1 = 10.7;
		i1 = (int)d1; //������� ����ȯ�� ������ �ս��� �� �� �ִ�
		
		System.out.print("i1="+i1);
	}
}
