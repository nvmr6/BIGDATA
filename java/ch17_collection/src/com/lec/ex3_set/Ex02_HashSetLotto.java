package com.lec.ex3_set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

public class Ex02_HashSetLotto {
	public static void main(String[] args) {
		HashSet<Integer> lotto = new HashSet<Integer>();
		Random random = new Random();
		while(lotto.size()<6) { //사이즈가 6이 될때까지
			lotto.add(random.nextInt(45)+1);
		}
		System.out.println(lotto);
	}
}
