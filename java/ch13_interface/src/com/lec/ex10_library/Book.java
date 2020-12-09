package com.lec.ex10_library;

public class Book implements ILendable {
	private String requestNo;
	private String bookTitle;
	private String writer;
	private String borrower;
	private String checkOutDate;
	private byte state;
	
	public Book(String requestNo, String bookTitle, String writer) {
		this.requestNo = requestNo;
		this.bookTitle = bookTitle;
		this.writer = writer;
		state = STATE_NORMAL;
	}

	@Override
	public void checkOut(String borrower, String checkOutDate) {
		if(state!=STATE_NORMAL) { //대출 불가시 리턴 null
			System.out.println("대출 불가");
			return ;
		}
		this.borrower = borrower;
		this.checkOutDate = checkOutDate;
		state = STATE_BORROWED;
		System.out.println("\"" + bookTitle+"\"가 대출되었습니다.");
		System.out.println("[대출인] "+borrower);
		System.out.println("[대출일] "+checkOutDate);
	}

	@Override
	public void checkin() {
		if(state==STATE_NORMAL) {
			System.out.println("이 책은 대출중이 아니라고 나옵니다.");
			return;
		}
		borrower = null;
		checkOutDate = null;
		state = STATE_NORMAL;
		System.out.println("\""+bookTitle+"\"이(가) 반납되었습니다.");
	}


	@Override
	public void printState() {
		if(state==STATE_BORROWED) {
			System.out.println("\"" + bookTitle+"\"은(는) 대출 중입니다.");
		}else if(state==STATE_NORMAL) {
			System.out.println("\"" + bookTitle+"\"은(는) 대출 가능합니다.");
		}else {
			System.out.println("\"" + bookTitle+"\"은(는) 알 수 없습니다.");
		}
	}

}
