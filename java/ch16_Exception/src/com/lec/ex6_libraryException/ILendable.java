package com.lec.ex6_libraryException;


public interface ILendable {
	public byte STATE_BORROWED = 1;//대출중
	public byte STATE_NORMAL = 0;//대출 가능
	public void checkin() throws Exception;//반납
	void checkOut(String borrower) throws Exception;
}
