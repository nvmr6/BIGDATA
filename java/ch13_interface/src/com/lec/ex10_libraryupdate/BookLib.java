package com.lec.ex10_libraryupdate;

public class BookLib extends BookInfo implements ILendable{
	private String borrower;
	private String checkOutDate;
	private byte state;
	public BookLib(String requestNo, String bookTitle, String writer) {
		super(requestNo, bookTitle, writer);
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
		System.out.println("\"" + getBookTitle()+"\"가 대출되었습니다.");
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
		System.out.println("\""+getBookTitle()+"\"이(가) 반납되었습니다.");
	}

	@Override
	public void printState() {
		if(state==STATE_BORROWED) {
			System.out.println("\"" + getBookTitle()+"\"은(는) 대출 중입니다.");
		}else if(state==STATE_NORMAL) {
			System.out.println("\"" + getBookTitle()+"\"은(는) 대출 가능합니다.");
		}else {
			System.out.println("\"" + getBookTitle()+"\"은(는) 알 수 없습니다.");
		}
	}

	public String getBorrower() {
		return borrower;
	}

	public String getCheckOutDate() {
		return checkOutDate;
	}

	public byte getState() {
		return state;
	}
	
}
