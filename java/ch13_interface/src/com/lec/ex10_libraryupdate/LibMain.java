package com.lec.ex10_libraryupdate;

import java.util.Scanner;

public class LibMain {
	public static void main(String[] args) {
		BookLib[] books = {new BookLib("1q2w3e", "java", "aaaaa"),
						   new BookLib("3e4r5t", "hadoop", "bbbbb"), 
					       new BookLib("4r5t6y", "oracle", "ccccc"),
					       new BookLib("4r5t6y", "python", "ddddd"), 
					       new BookLib("6y7u8i", "spark", "eeeee")};
		
		Scanner sc = new Scanner(System.in);
		int fn, idx =0; //기능 번호, 인덱스
		String bTitle, borrower, checkOutDate;
		
		do {
			System.out.print("1:대출 | 2:반납 | 3:도서현황 | 0:종료");
			fn = sc.nextInt();
			switch(fn) {
			case 1 : //대출 로직
//				System.out.println("대출진행");
				System.out.print("대출할 책 이름은?");
				 bTitle = sc.next(); //책이름을 스트링 받음, 스페이스 금지
				 for(idx=0;idx<books.length;idx++) {
					 if(bTitle.equals(books[idx].getBookTitle())) {//해당 번째 책 대출, 스트링 대조는 equals로
						 break;
					 }
				 }
				 //책은 찾은지 확인하고 대출 진행
				 if(idx==books.length) {
					 //못찾음
					 System.out.println("해당 도서는 존재하지 않습니다.");
				 }else if(books[idx].getState()==ILendable.STATE_BORROWED){
					 //찾음 > idx번째 대출 진행
					 System.out.println("현재 대출 중입니다.");
				 }else {
					 //대출 가능 > 대출인,대출일 입력
					 System.out.println("대출인?");
					 borrower = sc.next();
					 System.out.println("대출일?");
					 checkOutDate = sc.next();
					 books[idx].checkOut(borrower, checkOutDate);
				 }
				break;
			case 2 : //반납 로직
//				System.out.println("반납진행");
				System.out.println("반납할 책이름은?");
				bTitle = sc.next();
				 for(idx=0;idx<books.length;idx++) {
					 if(bTitle.equals(books[idx].getBookTitle())) {
						 break;
					 }
				 }
				 if(idx==books.length) {
					 System.out.println("해당 도서는 본 도서관의 도서가 아닙니다.");
				 }else{
					 books[idx].checkin();
				 }
				break;
			case 3 : //확인 로직
//				System.out.println("도서들 상태");
				for(BookLib temp: books) {
					temp.printState();
				}
			}
		}while(fn != 0);
		System.out.println("시스템 종료");
		sc.close();
	}
}
