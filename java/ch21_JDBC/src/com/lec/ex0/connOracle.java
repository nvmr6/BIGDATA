package com.lec.ex0;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connOracle {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Connection conn = null;
		try {
			// 1�ܰ�: driver load
			Class.forName(driver);
			System.out.println("Driver Load");
			//2�ܰ�: DB connection
			conn = DriverManager.getConnection(url, "scott", "tiger");
			System.out.println("DB Connection");
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage()+": ����̹� ����");
		} catch (SQLException e) {
			System.out.println(e.getMessage()+": ��ü ���� ����");
		}finally {
			try {
				if(conn != null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
