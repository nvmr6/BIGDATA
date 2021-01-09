package com.lec.person_dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

public class personDao {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	public static final int SUCCESS = 1;
	public static final int FAIL = 0;
	private static personDao INSTANCE;
	
	public static personDao getInstance() {
		if(INSTANCE==null) {
			INSTANCE = new personDao();
		}
		return INSTANCE;
	}//singleton pattern
	
	private personDao() {
		try {
			Class.forName(driver);
			
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
	
	//1번 insert
	public int insertPerson(personDto dto) {
		int result = FAIL;
		//dto값들을 DB에 넣는다
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO PERSON VALUES (SEQ_PERSON.NEXTVAL, ?, (SELECT JNO FROM JOB WHERE JNAME = ?), ?, ?, ?)";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getJname());
			pstmt.setInt(3, dto.getKor());
			pstmt.setInt(4, dto.getEng());
			pstmt.setInt(5, dto.getMat());
			result = pstmt.executeUpdate();
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
		return result;
	}
	
	//2번 jname 출력
	public ArrayList<personDto> selectJname(String jname){
		ArrayList<personDto> dtos = new ArrayList<personDto>();
		//janme인 사람들 dto에 add
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT ROWNUM RANK, S.*FROM(SELECT NAME||'('||NO||'번)' NAME, JNAME, KOR, ENG, MAT, KOR+ENG+MAT SUM FROM PERSON P, JOB J " + 
						"WHERE P.JNO = J.JNO AND JNAME = ? " + 
						"ORDER BY SUM DESC) S";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, jname);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int rank = rs.getInt("rank");
				String name = rs.getString("name");
//				jname = rs.getString("jname");
				int kor = rs.getInt("kor");
				int eng = rs.getInt("eng");
				int mat = rs.getInt("mat");
				int sum = rs.getInt("sum");
				dtos.add(new personDto(rank, name, jname, kor, eng, mat, sum));
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
		return dtos;
		
	} 
	
	//3번 출력
	public ArrayList<personDto> selectAll(){
		ArrayList<personDto> dtos = new ArrayList<personDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT ROWNUM RANK, S.*FROM(SELECT NAME||'('||NO||'번)' NAME, JNAME, KOR, ENG, MAT, KOR+ENG+MAT SUM FROM PERSON P, JOB J " + 
						"WHERE P.JNO = J.JNO ORDER BY SUM DESC) S";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int rank = rs.getInt("rank");
				String name = rs.getString("name");
				String jname = rs.getString("jname");
				int kor = rs.getInt("kor");
				int eng = rs.getInt("eng");
				int mat = rs.getInt("mat");
				int sum = rs.getInt("sum");
				dtos.add(new personDto(rank, name, jname, kor, eng, mat, sum));
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
		return dtos;
	}
	
	//직업명 가져오기
	public Vector<String> jnameList(){
		Vector<String> jnames = new Vector<String>();
		jnames.add("");
		//직업 리스트 add
		String sql = "SELECT JNAME FROM JOB";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				jnames.add(rs.getString("jname"));
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
		return jnames;
	}
}















