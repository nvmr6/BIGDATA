package com.lec.ex2_DataInputStream;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;

public class Ex03_ProductWrite {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String ans;
		OutputStream fos = null;
		DataOutputStream dosName = null;
		DataOutputStream dosPrice = null;
		DataOutputStream dosPs = null;
		do {
			System.out.println("재고 목록 입력을 진행하시겠습니까? (Y/N)");
			ans = sc.next();
			if(ans.equalsIgnoreCase("y")) {
				try { 
					fos = new FileOutputStream("txtfile/Product.dat",true);
					dosName = new DataOutputStream(fos);
					dosPrice = new DataOutputStream(fos);
					dosPs = new DataOutputStream(fos);
					System.out.print("물건명: ");
					dosName.writeUTF(sc.next());
					System.out.print("가격: ");
					dosPrice.writeUTF(sc.next());
					System.out.print("재고: ");
					dosPs.writeUTF(sc.next());
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}finally {
					try {
						if(dosName != null) dosName.close();
						if(dosPrice != null) dosPrice.close();
						if(dosPs != null) dosPs.close();
						if(fos != null) fos.close();
					} catch (IOException e) {
						System.out.println(e.getMessage());
					}
				}
			}else if(ans.equalsIgnoreCase("n")) {
				break;
			}
		}while(true);
		sc.close();
	}
}
