package com.lec.ex3_set;

import java.util.Random;
import java.util.TreeSet;

public class Ex03_TreeSetLotto2 {
	public static void main(String[] args) {
		TreeSet<Integer> lotto = new TreeSet<Integer>();
		Random random = new Random();
		while(lotto.size()<6) { //사이즈가 6이 될때까지
			lotto.add(random.nextInt(45)+1);
		}
		System.out.println(lotto);
	}
}
