package com.lec.ex;
//car myPorche = new car();
//myPorche.color = "red";
public class car {
	private String color; //�����ʹ� private / �޼��� public 
	private int cc;
	private int speed;
	
	public car() {//������ �Լ� / return�� ���� / Ŭ������� ���� �̸��� �޼���
		// ����Ʈ ������ �Լ��� ������ �Լ��� ���� �� JVM�� �ڵ� ����
		//��ü ������ ������ �� �ڵ� ȣ��
		cc = 1000;
	}
	
	public void drive(){
		speed = 60;
		System.out.println("�����մϴ�. ���� �ӵ�: "+speed);
		
	}
	public void park(){
		speed = 0;
		System.out.println("�����մϴ�. ���� �ӵ�: "+speed);
		
	}
	public void race(){
		speed = 120;
		System.out.println("�����մϴ�. ���� �ӵ�: "+speed);
	}
	
	public void setColor(String color){
		this.color = color; //this �� ��ü�� color
	}
	
	public String getColor(){
		return color;
	}
	
	public int getCc(){
		return cc;
	}
}
