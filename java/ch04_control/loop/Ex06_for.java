package com.lec.loop;

public class Ex06_for {
	public static void main(String[] args) {
		int tot = 0;
		for(int i=1;i<=10;i++) { //i+=2;
			if(i%2==1) {
				System.out.print(i);
				tot+=i;
				if(i!=9){
					System.out.print("+");
				}else {
					System.out.print("=");
				}
			}
		}
		System.out.println(tot);
	}
}
