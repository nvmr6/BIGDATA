package com.lec.ex1_InputStreamOutputStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

//1. 파일을 연다(스트림 객체 생성) 2. 데이터를 읽는다.(1,2 byte) 3.파일을 받는다.
public class Ex01_inputStream {
	public static void main(String[] args) {
		InputStream is = null; //스트림 변수 선언, finally절에서 닫음
		try {
			is = new FileInputStream("txtfile/in.txt"); //1단계
			//2단계
			while(true) {
				int i = is.read(); //1byte 읽기
				if(i==-1) break;
				System.out.println((char)i+" "+i);
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}finally {
			//3단계
			try {
				if(is!=null)
					is.close();
			} catch (IOException e) {}// 에러가 발생하지 않는다.
		}
		
	}
}
