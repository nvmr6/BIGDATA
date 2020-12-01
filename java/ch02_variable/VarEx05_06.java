package com.lec.ex;

public class VarEx05_06 {
	public static void main(String[] args){
		float f1,f2;
		double d1,d2;
		f1 = 3.14159265359f;
		d1 = 3.14159265359;
		System.out.println(f1);
		System.out.println(d1);
		
		f2 = 10.001f;
		d2 = 10.001;
		System.out.println("f2="+f2);
		System.out.println("d2="+d2);
		
		if(f2==d2)
			System.out.println("같다");
		else
			System.out.println("다르다");
		//값이 같을뿐 변수자체가 같지 않다
	}
}
