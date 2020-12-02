package com.lec.loop;

public class Ex07_for {
	public static void main(String[] args) {
		for(int i=1;i<=5;i++) {
			if(i==3)break; //정지{
			System.out.println("i="+i);
			}
		
		System.out.println("");
		
		for(int i=1;i<=5;i++) {
			if(i==3)continue; //생략{
			System.out.println("i="+i);
			}
		}
				
	}

