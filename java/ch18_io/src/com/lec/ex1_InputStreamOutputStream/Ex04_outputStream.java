package com.lec.ex1_InputStreamOutputStream;

import java.io.*;

public class Ex04_outputStream {
	public static void main(String[] args) {
		OutputStream os = null;
		try {
			os = new FileOutputStream("txtfile/out.txt",true); //1. 파일 열기, true > 파일 추가
			String str = "Hello, JAVA.";
			byte[] bs = str.getBytes();//스트링을 바이트 배열로 
			os.write(bs);//2. 파일 작성, 한번에 읽음
			System.out.println("complete");
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(os!=null) os.close(); //3. 파일 닫기
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
