package com.lec.ex5_printwriter;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

public class Ex01 {
	public static void main(String[] args) {
		PrintWriter pw = null;
		OutputStream os = null;
		try {
//			pw = new PrintWriter("txtfile/out.txt");
			os = new FileOutputStream("txtfile/out.txt");
			pw = new PrintWriter(os);
			pw.println("Bon\r\njour");
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(pw!=null) pw.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
