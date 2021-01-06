package com.lec.ex2selectWhere;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

//부서번호를 받아 부서정보 뿌리기
public class SelectWhereDeptno {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Connection conn = null; 
		Statement stmt = null; 
		ResultSet rs = null;
		Scanner sc = new Scanner(System.in);
		System.out.println("원하는 부서번호: ");
		int deptno = sc.nextInt();
		String sql = "SELECT * FROM DEPT WHERE DEPTNO ="+deptno;
		
		try {
			Class.forName(driver);
			System.out.println("Driver Load");
			conn = DriverManager.getConnection(url, "scott", "tiger");
			System.out.println("DB Connection");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				String dname = rs.getString("dname");
				String loc = rs.getString("loc");
				System.out.printf("부서명: %s \t 부서 위치: %s \n", dname, loc);
			}else {
				System.out.println("해당 부서가 존재하지 않습니다.");
			}
			
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
				try {
					if(rs!=null) rs.close();
					if(stmt!=null) stmt.close();
					if(conn!=null) conn.close(); //생성 역순으로 close
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
		}
		sc.close();
	}
}
