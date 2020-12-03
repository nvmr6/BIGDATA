package com.lec.ex;
//car myPorche = new car();
//myPorche.color = "red";
public class car {
	private String color; //데이터는 private / 메서드 public 
	private int cc;
	private int speed;
	
	public car() {//생성자 함수 / return이 없다 / 클래스명과 같은 이름의 메서드
		// 디폴트 생성자 함수는 생성자 함수가 없을 때 JVM이 자동 생성
		//객체 변수가 생성될 때 자동 호출
		cc = 1000;
	}
	
	public void drive(){
		speed = 60;
		System.out.println("주행합니다. 현재 속도: "+speed);
		
	}
	public void park(){
		speed = 0;
		System.out.println("주차합니다. 현재 속도: "+speed);
		
	}
	public void race(){
		speed = 120;
		System.out.println("가속합니다. 현재 속도: "+speed);
	}
	
	public void setColor(String color){
		this.color = color; //this 내 객체의 color
	}
	
	public String getColor(){
		return color;
	}
	
	public int getCc(){
		return cc;
	}
}
