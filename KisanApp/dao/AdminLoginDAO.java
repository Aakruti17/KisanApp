package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bean.AdminLoginBean;
import com.db.DBConnection;

public class AdminLoginDAO {
	
	private static Connection con;
	private static final String  q = "select email,contact from first_db.admin_info where email=? and contact=?";
	boolean flag = false;
	
	public AdminLoginDAO() {
		
		con = DBConnection.createConnection();
	}
	
	public String verifyLoginCredentials(AdminLoginBean albean) {
		
		try {
			
			PreparedStatement ps = con.prepareStatement(q);
			
			ps.setString(1, albean.getEmail());
			ps.setInt(2, albean.getContact());
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				if(albean.getEmail().equals(rs.getString(1)) && albean.getContact()==rs.getInt(2) ) {
					
					System.out.println("Login Success..........");
					flag=true;
					
				}
				
				
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
