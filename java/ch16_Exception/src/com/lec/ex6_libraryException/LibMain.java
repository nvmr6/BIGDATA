package com.lec.ex6_libraryException;

import java.util.Scanner;

public class LibMain {
	public static void main(String[] args) {
		Book[] books = { new Book("1q2w3e", "java", "aaaaa"), 
						 new Book("3e4r5t", "hadoop", "bbbbb"),
						 new Book("4r5t6y", "oracle", "ccccc"), 
						 new Book("4r5t6y", "python", "ddddd"),
						 new Book("6y7u8i", "spark", "eeeee") };
		
		Scanner sc = new Scanner(System.in);
		int fn = 0, idx = 0; // 기능 번호, 인덱스
		String bTitle, borrower;

		do {
			System.out.print("1:대출 | 2:반납 | 0:도서현황 | 그외:종료");
			try {
				fn = sc.nextInt();
			} catch (Exception e) {
				System.out.println("0,1,2 외는 종료");
				break;
			}
			switch (fn) {
			case 1: // 대출 로직
				// System.out.println("대출진행");
				System.out.print("대출할 책 이름은?");
				bTitle = sc.next(); // 책이름을 스트링 받음, 스페이스 금지
				for (idx = 0; idx < books.length; idx++) {
					if (bTitle.equals(books[idx].getBookTitle())) {// 해당 번째 책 대출, 스트링 대조는 equals로
						break;
					}
				}
				// 책은 찾은지 확인하고 대출 진행
				if (idx == books.length) {
					// 못찾음
					System.out.println("해당 도서는 존재하지 않습니다.");
				} else if (books[idx].getState() == ILendable.STATE_BORROWED) {
					// 찾음 > idx번째 대출 진행
					System.out.println("현재 대출 중입니다.");
				} else {
					// 대출 가능 > 대출인,대출일 입력
					System.out.println("대출인?");
					borrower = sc.next();
					try {
						books[idx].checkOut(borrower);
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}
				break;

			case 2: // 반납 로직
				// System.out.println("반납진행");
				System.out.println("반납할 책이름은?");
				bTitle = sc.next();
				for (idx = 0; idx < books.length; idx++) {
					if (bTitle.equals(books[idx].getBookTitle())) {
						break;
					}
				}
				if (idx == books.length) {
					System.out.println("해당 도서는 본 도서관의 도서가 아닙니다.");
				} else {
					try {
						books[idx].checkin();
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}
				break;
				
			case 0: // 확인 로직
				// System.out.println("도서들 상태");
				for (Book temp : books) {
					System.out.println(temp);
				}
			}
		} while (fn != 0);
		System.out.println("시스템 종료");
		sc.close();
	}
}
