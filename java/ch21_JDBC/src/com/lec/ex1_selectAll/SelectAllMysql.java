package com.lec.ex1_selectAll;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectAllMysql {
	public static void main(String[] args) {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/kimdb?serverTimezone=UTC";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String query = "SELECT * FROM PERSONAL";
		
		try {
			Class.forName(driver);
			System.out.println("Driver Load");
			conn = DriverManager.getConnection(url, "root", "mysql");
			System.out.println("DB Connection");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			System.out.println("���\t�̸�\t��å\t\t�����\t�Ի���\t\t�޿�\t�󿩱�\t�μ���ȣ");
			//�������� ������ Ȯ������ ���� ���
			if(rs.next()) {//��� ������ ����
				do {//do-while ������� ������ ù ���� ��µ��� ����
					int pno = rs.getInt("pno");
					String pname = rs.getString("pname");
					String job = rs.getString("job");
					int manager = rs.getInt("manager");
					Date startdate = rs.getDate("startdate");
					int pay = rs.getInt("pay");
					int bonus = rs.getInt("bonus");
					int dno = rs.getInt("dno");
					if(job!=null && job.length()<=7) {
						System.out.printf("%d\t%s\t%s\t\t%d\t%TF\t%d\t%d\t%d\n", pno, pname, job, manager, startdate, pay, bonus, dno);
						}else {
							System.out.printf("%d\t%s\t%s\t%d\t%TF\t%d\t%d\t%d\n", pno, pname, job, manager, startdate, pay, bonus, dno);
						}
				}while(rs.next());
			}else {//��� ������ ����
				System.out.println("��� ������ �����ϴ�.");
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close(); //���� �������� close
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
	}
	}
}
