package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.bean.AddProductsBean;
import com.db.DBConnection;

public class AddProductsDAO {
	
	private static Connection con;
	private static final String q = "insert into first_db.products values(?,?,?,?,?,?) ";
	boolean flag = false;
	public AddProductsDAO() {
		
		con = DBConnection.createConnection();
	}
	
	
	
	public String insertRecord(AddProductsBean apbean) {
		
		try {
			
			PreparedStatement ps = con.prepareStatement(q);
			
			ps.setString(1,null);
			ps.setString(2, apbean.getPname());
			ps.setString(3, apbean.getCname());
			ps.setString(4, apbean.getContents());
			ps.setInt(5, apbean.getPrice());
			ps.setString(6, apbean.getCategory());
			
			int res = ps.executeUpdate();
			
			if(res==1) {
				flag = true;
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		if(flag==true) {
			return "success";
		}
		
		
		return "fail";
	}
	
	

}
