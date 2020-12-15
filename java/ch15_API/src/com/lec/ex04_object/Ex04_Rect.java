package com.lec.ex04_object;

public class Ex04_Rect {
	public static void main(String[] args) {
		Rect[] r = {new Rect(),
					new Rect(10,20,"빨강"),
				    new Rect(5,40,"파랑"),
				    new Rect(30,20,"초록")};
		Rect mine = new Rect(30,20,"초록");
		
		for(int i=0;i<r.length;i++) {
			System.out.print(r[i]);
			if(mine.equals(r[i])) {
				System.out.println("- 일치");
			}else {
				System.out.println("- 불일치");
			}
		}
	}
}
