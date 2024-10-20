package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.bean.FarmerSignupBean;
import com.db.DBConnection;

public class FarmerSignupDAO {
	
	private Connection con;
	private PreparedStatement ps;
	private static final String q = "insert into first_db.farmers_info1 values(?,?,?,?,?,?)";
	private boolean flag = false;
	
	public FarmerSignupDAO() {
		
		con = DBConnection.createConnection();
		
	}
	
	
	
	public String insertRecord(FarmerSignupBean fsbean) {
		
		try {
			
			con = DBConnection.createConnection();
			ps= con.prepareStatement(q);
			ps.setString(1, null);
			ps.setString(2, fsbean.getName());
			ps.setLong(3, fsbean.getContact());
			ps.setString(4, fsbean.getVillage());
			ps.setString(5, fsbean.getUname());
			ps.setString(6, fsbean.getPwd());
			
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
