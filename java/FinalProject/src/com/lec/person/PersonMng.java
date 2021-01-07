package com.lec.person;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class PersonMng {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner sc = new Scanner(System.in);
		Connection conn = null; 
		PreparedStatement pstmt = null; 
		ResultSet rs = null;
		String fn;//function
		try {
			Class.forName(driver);//1�ܰ�� �ѹ���
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		do {
			System.out.println("1. �Է� | 2.������ ��� | 3. ��ü��� | �׿� ���� > ");
			fn = sc.next();
			switch (fn) {
			case "1":
				System.out.println("�̸� �Է�: ");
				String name = sc.next();
				System.out.println("���� �Է�: ");
				String jname = sc.next();
				System.out.println("�������� �Է�: ");
				int kor = sc.nextInt();
				System.out.println("�������� �Է�: ");
				int eng = sc.nextInt();
				System.out.println("�������� �Է�: ");
				int mat = sc.nextInt();
				String sql1 = "INSERT INTO PERSON VALUES (SEQ_PERSON.NEXTVAL, ?, (SELECT JNO FROM JOB WHERE JNAME = ?), ?, ?, ?)";
				try {
					conn = DriverManager.getConnection(url, "scott", "tiger");
					pstmt = conn.prepareStatement(sql1);
					pstmt.setString(1, name);
					pstmt.setString(2, jname);
					pstmt.setInt(3, kor);
					pstmt.setInt(4, eng);
					pstmt.setInt(5, mat);
					int result = pstmt.executeUpdate();
					System.out.println(result>0? "success":"fail");
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}finally {
					try {
						if(pstmt!=null) pstmt.close();
						if(conn!=null) conn.close();
					} catch (SQLException e) {
						System.out.println(e.getMessage());
					}
				}
				break;
			case "2":
				System.out.println("����� ���� �Է�: ");
				jname = sc.next();
				String sql2 = "SELECT ROWNUM RANK, S.*FROM(SELECT NAME||'('||NO||'��)' NAME, JNAME, KOR, ENG, MAT, KOR+ENG+MAT SUM FROM PERSON P, JOB J " + 
									"WHERE P.JNO = J.JNO AND JNAME = ? " + 
									"ORDER BY SUM DESC) S";
				try {
					conn = DriverManager.getConnection(url, "scott", "tiger");
					pstmt = conn.prepareStatement(sql2);
					pstmt.setString(1,jname);
					rs = pstmt.executeQuery();
					if(rs.next()) {
						System.out.println("���\t�̸�\t����\t����\t����\t����\t����");
						do {
							int rank = rs.getInt("rank");
							name = rs.getString("name");
							jname = rs.getString("jname");
							kor = rs.getInt("kor");
							eng = rs.getInt("eng");
							mat = rs.getInt("mat");
							int sum = rs.getInt("sum");
							System.out.println(rank+"\t"+name+"\t"+jname+"\t"+kor+"\t"+eng+"\t"+mat+"\t"+sum);
						}while(rs.next());
					}else {
						System.out.println("�ش� ������ ����� �����ϴ�.");
					}
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
				break;
			case "3":
				String sql3 = "SELECT ROWNUM RANK, S.*FROM(SELECT NAME||'('||NO||'��)' NAME, JNAME, KOR, ENG, MAT, KOR+ENG+MAT SUM FROM PERSON P, JOB J " + 
									"WHERE P.JNO = J.JNO ORDER BY SUM DESC) S";
				try {
					conn = DriverManager.getConnection(url, "scott", "tiger");
					pstmt = conn.prepareStatement(sql3);
					rs = pstmt.executeQuery();
					if(rs.next()) {
						System.out.println("���\t�̸�\t����\t����\t����\t����\t����");
						do {
							int rank = rs.getInt("rank");
							name = rs.getString("name");
							jname = rs.getString("jname");
							kor = rs.getInt("kor");
							eng = rs.getInt("eng");
							mat = rs.getInt("mat");
							int sum = rs.getInt("sum");
							System.out.println(rank+"\t"+name+"\t"+jname+"\t"+kor+"\t"+eng+"\t"+mat+"\t"+sum);
						}while(rs.next());
					}else {
						System.out.println("�ش� ������ ����� �����ϴ�.");
					}
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
				break;
			}
		}while(fn.equals("1")||fn.equals("2")||fn.equals("3"));
		System.out.println("END");
		sc.close();
	}
}
