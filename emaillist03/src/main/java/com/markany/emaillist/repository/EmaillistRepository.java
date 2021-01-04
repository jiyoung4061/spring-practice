package com.markany.emaillist.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.markany.emaillist.vo.EmaillistVo;

@Repository
public class EmaillistRepository {
	public List<EmaillistVo> findAll() {
		List<EmaillistVo> list = new ArrayList<>();

		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;

		try {
			conn = getConnection();
			// 3. SQL 준비
			String sql = " select no, first_name, last_name, email " + " from emaillist " + " order by no desc ";
			pstmt = conn.prepareStatement(sql);
			// 5. sql문 실행
			rs = pstmt.executeQuery();

			// 6. 데이터 가져오기
			while (rs.next()) {
				Long no = rs.getLong(1);
				String firstName = rs.getString(2);
				String lastName = rs.getString(3);
				String email = rs.getString(4);

				EmaillistVo vo = new EmaillistVo();
				vo.setEmail(email);
				vo.setFirstName(firstName);
				vo.setLastName(lastName);
				vo.setNo(no);

				list.add(vo);
			}

		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				
				// 3. 자원정리
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	public boolean insert(EmaillistVo vo) {
		boolean result = false;
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;

		try {
			conn = getConnection(); // sqlexception 여기서 처리
			// 3-1. SQL 준비
			String sql = " insert " + " into emaillist " + " values(null, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);

			// 4. 바인딩
			pstmt.setString(1, vo.getFirstName());
			pstmt.setString(2, vo.getLastName());
			pstmt.setString(3, vo.getEmail());

			// 5. sql문 실행
			int count = pstmt.executeUpdate();

			result = count == 1;

		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				// 3. 자원정리
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	private Connection getConnection() throws SQLException{
		Connection conn = null;
		try {
			
		// 1. jdbc driver 로딩하기 (driver를 구현한 interface를 메모리에 올려야함!)
		Class.forName("org.mariadb.jdbc.Driver");

		// 2. 연결하기-> driverManager 클래스
		String url = "jdbc:mysql://192.168.90.219:3307/webdb?characterEncoding=utf8";
		conn = DriverManager.getConnection(url, "webdb", "apfhd123"); // webdb, password
		System.out.println("connection success");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패:" + e);
		} 
		return conn;
	}
}
