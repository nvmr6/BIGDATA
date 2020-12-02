package com.lec.loop;

public class Ex05_for {
	public static void main(String[] args) {
		int tot = 1;
		for(int i=1;i<=10;i++) {
			System.out.print(i);
			tot*=i;
			if(i!=10){
				System.out.print("*");
			}else {
				System.out.print("=");
			}
		}
		System.out.println(tot);
	}
}
