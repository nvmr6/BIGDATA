package com.lec.report;

public class ReportDto {
	private int rank;
	private String sno;
	private String sname;
	private String mname;
	private int score;
	private int sexpel;
	
	public ReportDto(String sno, String sname, String mname, int score) {
		this.sno = sno;
		this.sname = sname;
		this.mname = mname;
		this.score = score;
	}

	public ReportDto(String sname, String mname, int score, int sexpel) {
		this.sname = sname;
		this.mname = mname;
		this.score = score;
		this.sexpel = sexpel;
	}
	
	public ReportDto(int rank, String sname, String mname, int score) {
		this.rank = rank;
		this.sname = sname;
		this.mname = mname;
		this.score = score;
	}

	@Override
	public String toString() {
		if(rank==0) {
			return sno+"\t"+sname+"\t"+mname+"\t"+score;
		}else {
			return rank+"\t"+sname+"\t"+mname+"\t"+score;
		}
	}
	public String getSno() {
		return sno;
	}
	public void setSno(String sno) {
		this.sno = sno;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getSexpel() {
		return sexpel;
	}
	public void setSexpel(int sexpel) {
		this.sexpel = sexpel;
	}
	
}
