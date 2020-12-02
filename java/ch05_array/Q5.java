package com.lec.ex;

public class Q5 {
	public static void main(String[] args) {
		int[] coinUtil = {500, 100, 50, 10};
		int money = 2680;
		int[] changes = new int[4];
		
		for(int i=0;i<coinUtil.length;i++) {
			changes[i] = (int)(money /coinUtil[i]); //몫이 동전 갯수
			money = money%coinUtil[i]; //나머지가 다음 거스름돈의 게산 대상
		}
		for(int i=0;i<changes.length;i++) {
			System.out.println(coinUtil[i]+"원짜리\t"+changes[i]+"개");//배열의 복사
		}
	}
}
