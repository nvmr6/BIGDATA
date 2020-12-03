package com.lec.ex;

public class Ex01 {
	public static void main(String[] args) {
		int tot = 0;
		for(int i= 1;i<=10;i++) {
			tot+=i;
		}
		System.out.println(tot);
		System.out.println((tot%2==0)? "Â¦¼ö":"È¦¼ö");
		
		tot = 0;
		for(int i= 1;i<=50;i++) {
			tot+=i;
		}
		System.out.println(tot);
		System.out.println((tot%2==0)? "Â¦¼ö":"È¦¼ö");
		
		tot = 0;
		for(int i= 1;i<=100;i++) {
			tot+=i;
		}
		System.out.println(tot);
		System.out.println((tot%2==0)? "Â¦¼ö":"È¦¼ö");
	}
}
