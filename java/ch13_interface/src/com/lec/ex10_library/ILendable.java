package com.lec.ex10_library;

public interface ILendable {
	public byte STATE_BORROWED = 1;//대출중
	public byte STATE_NORMAL = 0;//대출 가능
	public void checkOut(String borrower, String checkOutDate); //대출
	public void checkin();//반납
	public void printState();//대출 상태 출력
}
