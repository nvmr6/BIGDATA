package com.lec.ex1_tryCatch;

public class Ex04 {
	public static void main(String[] args) {
		int[] arr = {0,1,2};
		for(int i=0;i<arr.length;i++) {
			try {
				System.out.println("arr["+i+"]: "+arr[i]);
			}catch(ArrayIndexOutOfBoundsException e) {
				System.out.println("예외 메세지: "+e.getMessage());
			}finally {
				System.out.println("try절, catch절 후에도 반드시 실행");
			}
		}
		System.out.println("done");
	}
}
