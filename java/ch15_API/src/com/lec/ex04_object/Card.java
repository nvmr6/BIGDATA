package com.lec.ex04_object;

public class Card {
	private char shape;
	private int num;
	public Card(char shape, int num) {
		this.shape = shape;
		this.num = num;
	}
	
	@Override
	public String toString() {
		String result = "카드 모양은 "+shape+num;
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj!=null && obj instanceof Card) {
			return (shape == ((Card)obj).shape) && (num == ((Card)obj).num);
		}
		return false;
	}
	
}
