package com.lec.ex1_list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Ex03_arrVSlin {
	public static void main(String[] args) {
		ArrayList<String> arr = new ArrayList<String>();
		LinkedList<String> lin = new LinkedList<String>();
		System.out.println("array 끝인덱스로 추가시간: " + addSeqTime(arr));
		System.out.println("linked 끝인덱스로 추가시간: " + addSeqTime(lin));
		
		System.out.println("array 중간 인덱스 추가 시간: "+addRandTime(arr));
		System.out.println("link 중간 인덱스 추가 시간: "+addRandTime(lin));
		
		System.out.println("array 마지막 인덱스 삭제 시간: "+removeSeqTime(arr));
		System.out.println("link 마지막 인덱스 삭제 시간: "+removeSeqTime(lin));
		
		System.out.println("array 중간 인덱스 삭제 시간: "+removeRandTime(arr));
		System.out.println("link 중간 인덱스 삭제 시간: "+removeRandTime(lin));
	}

	private static long addSeqTime(List<String> list) {//둘 다 상속받은 List
		long start = System.currentTimeMillis();//시작시간
		for(int i=0;i<5000000;i++) {
			list.add("순차적으로 추가");
		}
		long end = System.currentTimeMillis();//종료시간
		return end - start;
	}
	
	private static long addRandTime(List<String> list) { 
		long start = System.currentTimeMillis();//시작시간
		for(int i=0;i<1000;i++) {
			list.add(100,"중간 인덱스 추가"); //linked가 빠르다
		}
		long end = System.currentTimeMillis();//종료시간
		return end - start;
	}
	
	private static long removeSeqTime(List<String> list) {//둘 다 상속받은 List
		long start = System.currentTimeMillis();//시작시간
		for(int i=list.size()-1;i>1000;i--) {
			list.remove(i); //array가 빠르다
		}
		long end = System.currentTimeMillis();//종료시간
		return end - start;
	}
	
	private static long removeRandTime(List<String> list) { 
		long start = System.currentTimeMillis();//시작시간
		for(int i=0;i<1000;i++) {
			list.remove(i); //
		}
		long end = System.currentTimeMillis();//종료시간
		return end - start;
	}
}
