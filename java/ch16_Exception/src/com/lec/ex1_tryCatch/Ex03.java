package com.lec.ex1_tryCatch;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex03 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int i,j=1;
		do {
			try {
				System.out.println("첫번째 수는 ");
				i = sc.nextInt();
				break;//오류 없을 시에 빠져나감
			}catch(InputMismatchException e) {
				System.out.println(e.getMessage());//오류메세지
				System.out.println("숫자를 넣어주세요.");
				sc.nextLine(); //refresh buffer
			}
		}while(true);
		
		System.out.println("두번째 수는 ");
		try {
			j = sc.nextInt();
			System.out.println("i = "+i+" j = "+j);
			System.out.println("i+j="+(i+j));
			System.out.println("i-j="+(i-j));
			System.out.println("i*j="+(i*j));
			System.out.println("i/j="+(i/j)); // try안에 try는 넣지 않는다.
		}catch(InputMismatchException e) {
			System.out.println(e.getMessage());
			System.out.println("두번째 수를 입력하여 1로 초기화합니다.");
		}catch(ArithmeticException e) {//catch절만 아래에 작성, 순서대로 예외 처리
			System.out.println(e.getMessage());
			System.out.println("0으로 연산이 불가능합니다.");
		}catch(Exception e) {
			System.out.println(e.getMessage()+"다른 에러");
		}
		System.out.println("Done.");
		sc.close();
	}
}
