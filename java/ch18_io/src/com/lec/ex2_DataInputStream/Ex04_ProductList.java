package com.lec.ex2_DataInputStream;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class Ex04_ProductList {
	public static void main(String[] args) {
		InputStream fis = null;
		DataInputStream disName = null;
		DataInputStream disPrice = null;
		DataInputStream disPs = null;
		String name=null,price=null,ps=null;
		ArrayList<Product> products = new ArrayList<Product>();
		try {
			fis = new FileInputStream("txtfile/Product.dat");
			disName = new DataInputStream(fis);
			disPrice = new DataInputStream(fis);
			disPs = new DataInputStream(fis);
			while(true) {
				name = disName.readUTF();
				price = disPrice.readUTF();
				ps = disPs.readUTF();
				products.add(new Product(name,price,ps)); 
			}
		} catch (IOException e) {
			System.out.println("Product.dat 데이터 출력");
		}finally{
			try {
				if(disName != null) disName.close();
				if(disPrice != null) disPrice.close();
				if(disPs != null) disPs.close();
				if(fis != null) fis.close();//순서 반대로
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
		System.out.println("물건명\t가격\t재고");
		System.out.println("----------------------");
		for(Product temp: products) {
			System.out.println(temp);
		}
	}
}
