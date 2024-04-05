package com.shop.model;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


public class CategoryDAO {

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs, rs1 = null;
	String sql = null;
	private static CategoryDAO instance;
	
	private CategoryDAO() {  }
	public static CategoryDAO getInstance() {
		
		if(instance == null) {
			instance = new CategoryDAO();
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
	public List<Category> findAllCategory() {
		String sql1 = 
				"""
				select * from shop_category
				""";
		List<Category> categoryList = new ArrayList<>() ;
		
		try {
			openConn();
			pstmt = con.prepareStatement(sql1);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Category category = new Category(
					rs.getInt("CATEGORY_NUM"),
					rs.getString("CATEGORY_CODE"),
					rs.getString("CATEGORY_NAME")
				);
				categoryList.add(category);
			}
		
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeConn(rs, pstmt,  con);
		}
		
		return categoryList;
	}
	
	public boolean insertCatagory(Category category) {
		String sql1 = 
				"""
				select max(category_num) from shop_category
				""";
		
		String sql2 = 
				"""
				insert into shop_category
				 values(?,?,?)
				""";
		boolean result = false;
		try {
			openConn();
			Integer maxNumber = 0;
			pstmt = con.prepareStatement(sql1);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				maxNumber = rs.getInt("max(category_num)")+1;
			}
			
			if(maxNumber == null) maxNumber = 1;
			
			pstmt = con.prepareStatement(sql2);
			pstmt.setInt(1, maxNumber);
			pstmt.setString(2, category.getCategoryCode());
			pstmt.setString(3, category.getCategoryName());
			result = (pstmt.executeUpdate() == 1);
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeConn(pstmt, con);
		}
		
		return result;
	}
}

