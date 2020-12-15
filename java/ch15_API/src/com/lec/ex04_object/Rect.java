package com.lec.ex04_object;

public class Rect {
	private int width;
	private int height;
	private String color;
	public Rect() {
		width = 0;
		height = 0;
		color = "black";
	}
	public Rect(int width, int height, String color) {
		this.width = width;
		this.height = height;
		this.color = color;
	}
	
	@Override
	public String toString() {
		return "[가로 "+width+"cm, 세로 "+height+"cm의 "+color+"색의 사각형]";
	}
	@Override
	public boolean equals(Object obj) {
		if(obj!=null && obj instanceof Rect) {
			return (width == ((Rect)obj).width) && (height == ((Rect)obj).height) && (color == ((Rect)obj).color);
		}
		return false;
	}
}
