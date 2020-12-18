package com.lec.ex2_DataInputStream;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Ex02 {
	public static void main(String[] args) {
		InputStream fis = null;
		DataInputStream dis = null;
		
		try {
			fis = new FileInputStream("txtfile/datafile.dat");
			dis = new DataInputStream(fis);
			String name = dis.readUTF();
			int grade = dis.readInt();
			double score = dis.readDouble();//순서 지켜야함
			System.out.println(name+" "+grade+" "+score);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}finally{
			try {
				if(dis != null) dis.close();
				if(fis != null) fis.close();//순서 반대로
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
