package com.lec.student;

public class Student {
	private String name;
	private int kor;
	private int eng;
	private int mat;
	private int tot;
	private double avg;
	public static int count = 1;
	
	public Student() {}
	public Student(String name, int kor, int eng, int mat) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		
	}
	public void printScore() {
		++count;
		System.out.print("  "+name+"\t"+kor+"\t"+eng+"\t"+mat+"\t"+tot+"\t"+(int)avg+"\n");
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getKor() {
		return kor;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getEng() {
		return eng;
	}
	public void setMat(int mat) {
		this.mat = mat;
	}
	public int getMat() {
		return mat;
	}
	public void setTot() {
		this.tot = kor + eng + mat;
	}
	public int getTot() {
		return tot;
	}
	public void setAvg() {
		this.avg = (kor + eng + mat)/3;
	}
	public double getAvg() {
		return avg;
	}
}
