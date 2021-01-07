package com.lec.ex6preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertDept {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner sc = new Scanner(System.in);
		System.out.println("추가할 부서번호: ");
		String deptno = sc.next();
		System.out.println("원하는 부서명: ");
		String dname = sc.next();
		System.out.println("원하는 부서위치: ");
		sc.nextLine(); 
		String loc = sc.nextLine();
		String sql = "INSERT INTO DEPT VALUES (?, ?, ?)";
		Connection conn = null; 
		PreparedStatement pstmt = null; 
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);// (sql)
			pstmt.setString(1, deptno);//변수가 String이기 때문에
			pstmt.setString(2, dname);
			pstmt.setString(3, loc);
			int result = pstmt.executeUpdate();
			System.out.println(result>0? "success":"fail");
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close(); //생성 역순으로 close
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
	}
	sc.close();
	}
}
