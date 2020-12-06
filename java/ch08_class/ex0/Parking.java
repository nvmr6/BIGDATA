package com.lec.ex0;

import com.lec.cons.PiClass;

public class Parking {
	private String no;
	private int inTime;
	private int outTime;
	private int fee;
//	private final int RATE = 2000; //변수값 고정 > 공유 변수 사용
	
	public Parking() {}
	public Parking(String no, int inTime) {
		this.no = no;
		this.inTime = inTime;
		System.out.printf("%s님 어서오세요.\n",no);
		System.out.printf("입차 시간: %d시\n",inTime);
		System.out.println("");
	}
	
	public void out(int outTime) {
		this.outTime = outTime;
		if(outTime < inTime) {
			fee = (outTime - inTime+24)*PiClass.HOURLYRATE;
		}else {
			fee = (outTime - inTime)*PiClass.HOURLYRATE;
		}
		System.out.printf("%s님 안녕히 가세요.\n",no);
		System.out.printf("입차 시간: %d시\n",inTime);
		System.out.printf("출차 시간: %d시\n",outTime);
		System.out.printf("주차요금은 %d원입니다.\n",fee);
		System.out.println("");
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getNo() {
		return no;
	}
	public void setInTime(int inTime) {
		this.inTime = inTime;
	}
	public int getInTime() {
		return inTime;
	}
	public void setOutTime(int outTime) {
		this.outTime = outTime;
	}
	public int getOutTime() {
		return outTime;
	}
	public void setFee(int fee) {
		this.fee = fee;
	}
	public int getFee() {
		return fee;
	}
}
