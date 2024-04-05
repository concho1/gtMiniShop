package com.shop.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


public class ProductDAO {

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs, rs1 = null;
	String sql = null;
	private static ProductDAO instance;
	
	private ProductDAO() {  }
	public static ProductDAO getInstance() {
		
		if(instance == null) {
			instance = new ProductDAO();
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
		
	}
	public List<Product> findAllproduct() {
		String sql1 = 
				"""
				select * from shop_products
				""";
		List<Product> productList = new ArrayList<>() ;
		
		try {
			openConn();
			pstmt = con.prepareStatement(sql1);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Product product = new Product(
					rs.getInt("PNUM"),
					rs.getString("PNAME"),
					rs.getString("PCATEGORY_FK"),
					rs.getString("PCOMPANY"),
					rs.getString("PIMAGE"),
					rs.getInt("PQTY"),
					rs.getDouble("PRICE"),
					rs.getString("PSPEC"),
					rs.getString("PCONTENTS"),
					rs.getInt("POINT"),
					rs.getString("PINPUTDATE")
				);
				productList.add(product);
			}
		
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeConn(rs, pstmt,  con);
		}
		
		return productList;
	}
	
	public boolean insertProduct(Product product) {
		String sql1 = 
				"""
				select max(PNUM) from shop_products
				""";
		
		String sql2 = 
				"""
				insert into shop_products
				 values(?,?,?,?,?,?,?,?,?,?,sysdate)
				""";
		boolean result = false;
		try {
			openConn();
			Integer maxNumber = 0;
			pstmt = con.prepareStatement(sql1);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				maxNumber = rs.getInt("max(PNUM)")+1;
			}
			
			if(maxNumber == null) maxNumber = 1;
			
			pstmt = con.prepareStatement(sql2);
			pstmt.setInt(1, maxNumber);
			pstmt.setString(2, product.getPname());
			pstmt.setString(3, product.getPcategoryFk());
			pstmt.setString(4, product.getPcompany());
			pstmt.setString(5, product.getPimage());
			pstmt.setInt(6, product.getPqty());
			pstmt.setDouble(7, product.getPrice());
			pstmt.setString(8, product.getPspec());
			pstmt.setString(9, product.getPcontents());
			pstmt.setInt(10, product.getPoint());
			
			result = (pstmt.executeUpdate() == 1);
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeConn(pstmt, con);
		}
		
		return result;
	}
	
}

