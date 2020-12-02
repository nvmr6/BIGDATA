package com.lec.ex;

public class Q4 {
	public static void main(String[] args) {
		int[] array = {76,45,34,89,100,50,90,92};
		int sum=0,avg=0,min=999,max=0; //최대 최소를 서로 반대로 지정하여 거슬러 올라가도록 설정
		for(int i=0; i<array.length;i++) {
			sum+=array[i];
			if(array[i]>max) {max = array[i];} //비교하여 올라감
			if(array[i]<min) {min = array[i];} //비교하여 내려감
		}
		avg = sum/array.length;
		System.out.printf("합계: %d, 평균: %d \n",sum,avg);
		System.out.printf("최소: %d, 최대: %d \n",min,max);
	}
}
