package com.lec.ex2_DataInputStream;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

//
public class Ex01 {
	public static void main(String[] args) {
		OutputStream fos = null;
		DataOutputStream dos = null; //보조 스트림
		try { //보조 스트림은 기본 스트림을 통해서만 생성
			fos = new FileOutputStream("txtfile/datafile.dat");
			dos = new DataOutputStream(fos);
			dos.writeUTF("홍길동");//스트링 저장
			dos.writeInt(2);//int값 저장
			dos.writeDouble(95.9);//double값 저장, //순서 지켜야함
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(dos != null) dos.close();
				if(fos != null) fos.close();//순서 반대로
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
