package com.lec.ex6_libraryException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Book implements ILendable {
	private String requestNo;
	private String bookTitle;
	private String writer;
	private String borrower;
	private byte state;
	private Date checkOutDate;

	public Book(String requestNo, String bookTitle, String writer) {
		this.requestNo = requestNo;
		this.bookTitle = bookTitle;
		this.writer = writer;
		state = STATE_NORMAL;
	}

	@Override
	public void checkOut(String borrower) throws Exception {
		if (state != STATE_NORMAL) { // 대출 불가시 리턴 null
			throw new Exception(bookTitle + "은 대출중");//예외처리
		}
		this.borrower = borrower;
		checkOutDate = new Date();
		state = STATE_BORROWED;
		System.out.println("\"" + bookTitle + "\"가 대출되었습니다.");
		System.out.println("[대출인] " + borrower);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 E요일");
		System.out.println("[대출일] " + sdf.format(checkOutDate));
	}

	@Override
	public void checkin() throws Exception {
		if (state == STATE_NORMAL) {
			throw new Exception(bookTitle + "은 대출중이 아니라고 나옵니다.");//예외처리
		}
		Date now = new Date();
		long diff = now.getTime() - checkOutDate.getTime();
		long dayD = diff / (1000 * 60 * 60 * 24);
		if (dayD > 14) {
			dayD -= 14;
			System.out.println("연체료 " + (dayD * 100) + "원을 받아야합니다.");
			Scanner sc = new Scanner(System.in);
			System.out.println("연체료를 납부하셨나요? (y/n)");
			String ok = sc.next();
			if (!ok.equalsIgnoreCase("y")) {
				System.out.println("연체료를 납부해주셔야 합니다.");
				return;
			}
		}
		borrower = null;
		checkOutDate = null;
		state = STATE_NORMAL;
		System.out.println("\"" + bookTitle + "\"이(가) 반납되었습니다.");
	}

	public String toString() {
		if (state == STATE_BORROWED) {
			return "\"" + bookTitle + "\"은(는) 대출 중입니다.";
		} else if (state == STATE_NORMAL) {
			return "\"" + bookTitle + "\"은(는) 대출 가능합니다.";
		} else {
			return "\"" + bookTitle + "\"은(는) 알 수 없습니다.";
		}
	}

	public String getRequestNo() {
		return requestNo;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public String getWriter() {
		return writer; 
	}

	public String getBorrower() {
		return borrower;
	}

	public Date getCheckOutDate() {
		return checkOutDate;
	}

	public byte getState() {
		return state;
	}

}
