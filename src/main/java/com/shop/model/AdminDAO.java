package com.shop.model;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


public class AdminDAO {

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs, rs1 = null;
	String sql = null;
	private static AdminDAO instance;
	
	private AdminDAO() {  }
	public static AdminDAO getInstance() {
		
		if(instance == null) {
			instance = new AdminDAO();
		}
		
		return instance;
	}
	
	
	public void openConn() {
		try {
			Context initCtx = new InitialContext();
			Context ctx = (Context)initCtx.lookup("java:comp/env");
			DataSource ds = (DataSource)ctx.lookup("jdbc/myoracle");
			con = ds.getConnection();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}  
		
	
	// DB에 연결되어 있던 자원 종료하는 메서드.
	public void closeConn(ResultSet rs,
		PreparedStatement pstmt, Connection con) {
	
		try {
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			if(con != null) con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}  // closeConn() 메서드 end
	
	
	// DB에 연결되어 있던 자원 종료하는 메서드.
	public void closeConn(
			PreparedStatement pstmt, Connection con) {
		
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}  // closeConn() 메서드 end
	
	
	public Optional<Admin> getAdminById(String adminId) {
		
		Optional<Admin> resultAdmin = null;
		
		try {
			openConn();
			
			sql = "select * from shop_admin where admin_id=?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, adminId);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				Admin admin = new Admin(
					rs.getString("admin_id"),
					rs.getString("admin_pwd"),
					rs.getString("admin_name"),
					rs.getString("admin_email"),
					rs.getString("admin_phone"),
					rs.getDate("admin_date")
				);
				resultAdmin = Optional.ofNullable(admin);
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			closeConn(rs, pstmt, con);
		}
		return resultAdmin;
	}
	
}

