package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.bean.AdminSignupBean;
import com.db.DBConnection;

public class AdminSignupDAO {
	
	Connection con = null;
	
	//Logic to create Connection object by calling createConnection() method on DBConnection class inside constructor 
	//As soon as AdminSignupDAO class object will be created ... this constructor will be called
	//so this given logic will execute ... and Connection object will be created
	public AdminSignupDAO() {
		
		 con = DBConnection.createConnection();
		
	}
	
	private static final String q = "insert into first_db.admin_info values(?,?,?,?,?)";
	
	
	public String insertData(AdminSignupBean asbean){
		
		try {
			
			//create PreparedStatement object
			PreparedStatement ps = con.prepareStatement(q);
			
			//set values to query params
			ps.setString(1,null);
			ps.setString(2, asbean.getName());
			ps.setString(3,asbean.getEmail());
			ps.setInt(4,asbean.getContact());
			ps.setString(5,asbean.getAddress());
			
			//execute the query
			int res = ps.executeUpdate();
			
			if(res==1) {
				return "success";
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "fail";
		
	}
	

}
