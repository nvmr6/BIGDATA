package com.lec.ex10_libraryupdate;

public class BookInfo  {
	private String requestNo;
	private String bookTitle;
	private String writer;
	
	
	public BookInfo(String requestNo, String bookTitle, String writer) {
		super();
		this.requestNo = requestNo;
		this.bookTitle = bookTitle;
		this.writer = writer;
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

}
