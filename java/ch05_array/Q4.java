package com.lec.ex;

public class Q4 {
	public static void main(String[] args) {
		int[] array = {76,45,34,89,100,50,90,92};
		int sum=0,avg=0,min=999,max=0; //�ִ� �ּҸ� ���� �ݴ�� �����Ͽ� �Ž��� �ö󰡵��� ����
		for(int i=0; i<array.length;i++) {
			sum+=array[i];
			if(array[i]>max) {max = array[i];} //���Ͽ� �ö�
			if(array[i]<min) {min = array[i];} //���Ͽ� ������
		}
		avg = sum/array.length;
		System.out.printf("�հ�: %d, ���: %d \n",sum,avg);
		System.out.printf("�ּ�: %d, �ִ�: %d \n",min,max);
	}
}
