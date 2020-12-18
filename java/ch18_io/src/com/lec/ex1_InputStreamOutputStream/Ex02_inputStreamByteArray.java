package com.lec.ex1_InputStreamOutputStream;

import java.io.*;

public class Ex02_inputStreamByteArray {
	public static void main(String[] args) {
		InputStream is =null;
		try {
			is = new FileInputStream("txtfile/out.txt");//1단계
			byte[] bs = new byte[10];
			while(true) {
//				int i = is.read(); //1byte 읽기
//				if(i==-1) break;
//				System.out.println((char)i+" "+i);
				int readByteCount = is.read(bs); // 10바이트씩 읽기
				if(readByteCount == -1) break;
				for(int i=0;i<readByteCount; i++) {
					System.out.print((char)bs[i]);
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(is != null) is.close();//3단계
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
