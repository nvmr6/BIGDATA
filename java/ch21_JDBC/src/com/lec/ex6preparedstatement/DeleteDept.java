package com.lec.ex6preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteDept {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Connection conn = null; 
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Scanner sc = new Scanner(System.in);
		String selectquery = "SELECT * FROM DEPT WHERE DEPTNO=?";
		String deletequery = "DELETE FROM DEPT WHERE DEPTNO = ?";
		
		System.out.println("������ �μ���ȣ: ");
		String deptno = sc.next();
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(selectquery);
			pstmt.setString(1,deptno);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				System.out.println("�����Ͻðڽ��ϱ�? (y/n)");
				String ans = sc.next();
				if(ans.equalsIgnoreCase("y")) {
					rs.close();
					pstmt.close();
					pstmt = conn.prepareStatement(deletequery);
					pstmt.setString(1,deptno);
					int result = pstmt.executeUpdate(deletequery);
					System.out.println(result>0? deptno+"�� �μ� ����":"�ش� �μ� �������� ����");
				}
			}else {
				System.out.println("��ȿ���� ���� �μ� ��ȣ");
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
	}
	sc.close();
	}
}
