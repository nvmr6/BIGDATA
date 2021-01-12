package com.lec.customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

public class CustomerDao {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	public static final int SUCCESS = 1;
	public static final int FAIL = 0;
	private static CustomerDao INSTANCE;

	public static CustomerDao getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new CustomerDao();
		}
		return INSTANCE;
	}

	private CustomerDao() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	// 1번 아이디 검색
	public CustomerDto cIdGetCustomers(int cId) {
		CustomerDto person = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, "
				+ "(SELECT HIGH-CAMOUNT+1 FROM CUSTOMER WHERE CID = C.CID AND LEVELNO!=5) FORLEVELUP "
				+ "FROM CUSTOMER C, CUS_LEVEL L " + "WHERE C.LEVELNO = L.LEVELNO AND CID = ?";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cId);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String ctel = rs.getString("ctel");
				String cname = rs.getString("cname");
				int cpoint = rs.getInt("cpoint");
				int camount = rs.getInt("camount");
				String levelname = rs.getString("levelname");
				int forlevelup = rs.getInt("forlevelup");
				person = new CustomerDto(cId, ctel, cname, cpoint, camount, levelname, forlevelup);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return person;
	}

	// 2번 전화번호 검색
	public ArrayList<CustomerDto> cTelGetCustomers(String cTel) {
		ArrayList<CustomerDto> person = new ArrayList<CustomerDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, "
				+ "(SELECT HIGH-CAMOUNT+1 FROM CUSTOMER WHERE CID = C.CID AND LEVELNO!=5) FORLEVELUP "
				+ "FROM CUSTOMER C, CUS_LEVEL L " + "WHERE C.LEVELNO = L.LEVELNO AND CTEL LIKE '%'||?";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cTel);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int cid = rs.getInt("cid");
				String ctel = rs.getString("ctel");
				String cname = rs.getString("cname");
				int cpoint = rs.getInt("cpoint");
				int camount = rs.getInt("camount");
				String levelname = rs.getString("levelname");
				int forlevelup = rs.getInt("forlevelup");
				person.add(new CustomerDto(cid, ctel, cname, cpoint, camount, levelname, forlevelup));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return person;
	}

	// 3번 이름 검색
	public ArrayList<CustomerDto> cNameGetCustomers(String cName) {
		ArrayList<CustomerDto> person = new ArrayList<CustomerDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, "
				+ "(SELECT HIGH-CAMOUNT+1 FROM CUSTOMER WHERE CID = C.CID AND LEVELNO!=5) FORLEVELUP "
				+ "FROM CUSTOMER C, CUS_LEVEL L " + "WHERE C.LEVELNO = L.LEVELNO AND CNAME = ?";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cName);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int cid = rs.getInt("cid");
				String ctel = rs.getString("ctel");
				int cpoint = rs.getInt("cpoint");
				int camount = rs.getInt("camount");
				String levelname = rs.getString("levelname");
				int forlevelup = rs.getInt("forlevelup");
				person.add(new CustomerDto(cid, ctel, cName, cpoint, camount, levelname, forlevelup));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return person;
	}

	// 4번 포인트로 구매
	public int buyWithPoint(int cAmount, int cId) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE CUSTOMER SET CPOINT = CPOINT - ? WHERE CID = ? AND CPOINT > ?";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cAmount);
			pstmt.setInt(2, cId);
			pstmt.setInt(3, cAmount);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}

	// 5번 물품 구매
	public int buy(int cAmount, String cTel, int cId) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE CUSTOMER SET CPOINT = CPOINT + ?*0.05, CAMOUNT = CAMOUNT + ?, "
				+ "LEVELNO = (SELECT L.LEVELNO FROM CUSTOMER C, CUS_LEVEL L WHERE CAMOUNT+? BETWEEN LOW AND HIGH AND CID = ?) "
				+ "WHERE CID = ? AND CTEL LIKE '%'||?";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cAmount);
			pstmt.setInt(2, cAmount);
			pstmt.setInt(3, cAmount);
			pstmt.setInt(4, cId);
			pstmt.setInt(5, cId);
			pstmt.setString(6, cTel);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}

	// 6번 등급별 출력
	public ArrayList<CustomerDto> levelNameGetCustomers(String levelName) {
		ArrayList<CustomerDto> person = new ArrayList<CustomerDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, "
				+ "(SELECT HIGH-CAMOUNT+1 FROM CUSTOMER WHERE CID = C.CID AND LEVELNO!=5) FORLEVELUP "
				+ "FROM CUSTOMER C, CUS_LEVEL L " + "WHERE C.LEVELNO = L.LEVELNO AND LEVELNAME = ? " + "ORDER BY CID";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, levelName);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int cid = rs.getInt("cid");
				String ctel = rs.getString("ctel");
				String cname = rs.getString("cname");
				int cpoint = rs.getInt("cpoint");
				int camount = rs.getInt("camount");
				int forlevelup = rs.getInt("forlevelup");
				person.add(new CustomerDto(cid, ctel, cname, cpoint, camount, levelName, forlevelup));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return person;
	}

	// 7번 전체 출력
	public ArrayList<CustomerDto> getCustomers() {
		ArrayList<CustomerDto> person = new ArrayList<CustomerDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, "
				+ "(SELECT HIGH-CAMOUNT+1 FROM CUSTOMER WHERE CID = C.CID AND LEVELNO!=5) FORLEVELUP "
				+ "FROM CUSTOMER C, CUS_LEVEL L " + "WHERE C.LEVELNO = L.LEVELNO " + "ORDER BY CID";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int cid = rs.getInt("cid");
				String ctel = rs.getString("ctel");
				String cname = rs.getString("cname");
				int cpoint = rs.getInt("cpoint");
				int camount = rs.getInt("camount");
				String levelname = rs.getString("levelname");
				int forlevelup = rs.getInt("forlevelup");
				person.add(new CustomerDto(cid, ctel, cname, cpoint, camount, levelname, forlevelup));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return person;
	}

	// 8번 회원가입
	public int insertCustomer(CustomerDto dto) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO CUSTOMER (CID, CTEL, CNAME) VALUES ( CUS_SEQ.NEXTVAL ,?,?)";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getcTel());
			pstmt.setString(2, dto.getcName());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}

	// 9번 전화번호 수정
	public int updateCustomer(String cTel, int cId) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE CUSTOMER SET CTEL = ? WHERE CID = ?";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cTel);
			pstmt.setInt(2, cId);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}

	// 10번 회원 탈퇴
	public int deleteCustomer(int cId) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM CUSTOMER WHERE CID = ?";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cId);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}

	// levelnames
	public Vector<String> levels() {
		Vector<String> levels = new Vector<String>();
		levels.add("");
		String sql = "SELECT LEVELNAME FROM CUS_LEVEL ORDER BY LEVELNO";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				levels.add(rs.getString("levelname"));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return levels;
	}
}
