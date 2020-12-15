package com.lec.ex04_object;

public class Ex02_Card {
	public static void main(String[] args) {
		Card[] card = {new Card('♥',2),
					   new Card('◆', 7),
					   new Card('♣', 8)};
		Card yours = new Card('♣', 8);
		System.out.println("당신 카드: "+yours);
		
		for(int i=0;i<card.length;i++) {
			System.out.println(card[i]);
			if(yours.equals(card[i])) {
				System.out.println("> 당신의 카드와 일치합니다.");
			}else {
				System.out.println("> 당신의 카드와 일치하지 않습니다.");
			}
		}
	}
}



