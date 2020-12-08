package com.lec.ex06_lunch;

import com.lec.cons.PriceTable;

public class TestMain {
	public static void main(String[] args) {
		LunchMenu Child1 = new Child1(PriceTable.RICE, PriceTable.BULGOGI, PriceTable.SOUP, 
									  PriceTable.MILK, PriceTable.BANANA, PriceTable.ALMOND);
		LunchMenu Child2 = new Child1(PriceTable.RICE, PriceTable.BULGOGI, PriceTable.SOUP, 
				  					  PriceTable.MILK, PriceTable.BANANA, PriceTable.ALMOND);
		System.out.println("Child1 식대: "+Child1.calculate());
		System.out.println("Child2 식대: "+Child2.calculate());
	}
}
