package com.lec.ex6preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertDept2 {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Connection conn = null; 
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Scanner sc = new Scanner(System.in);
		String insertsql = "INSERT INTO DEPT VALUES (?, ?, ?)";
		String selectsql = "SELECT * FROM DEPT WHERE DEPTNO = ?";
		
		System.out.println("추가할 부서번호: ");
		int deptno = sc.nextInt();
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(selectsql);
			pstmt.setInt(1, deptno);
			rs = pstmt.executeQuery();
			if(!rs.next()) {
				System.out.println("원하는 부서명: ");
				String dname = sc.next();
				System.out.println("원하는 부서위치: ");
				sc.nextLine(); 
				String loc = sc.nextLine();
				rs.close();
				pstmt.close();//닫고 다시 생성
				pstmt = conn.prepareStatement(insertsql);
				pstmt.setInt(1, deptno);
				pstmt.setString(2, dname);
				pstmt.setString(3, loc);
				int result = pstmt.executeUpdate();//정수로 리턴
				System.out.println(result>0? "success":"fail");
			}else {
				System.out.println("중복된 부서 번호");
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close(); //생성 역순으로 close
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
	}
	sc.close();
	}
}
