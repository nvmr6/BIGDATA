package com.lec.ex;

public class VarEx07 {
	public static void main(String[] args){
		int i1 = 10; //4bytes
		long l1 = 10; /*8바이트 안에 4바이트 할당하기 위해 
						4바이트의 10이 8바이트 long형으로 묵시적인 형변환*/
		double d1 = i1; //묵시적인 형변환
		
		//명시적인 형변환
		d1 = 10.7;
		i1 = (int)d1; //명시적인 형변환시 데이터 손실이 올 수 있다
		
		System.out.print("i1="+i1);
	}
}
