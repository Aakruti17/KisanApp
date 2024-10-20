package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.bean.UpdateNewsBean;
import com.db.DBConnection;

public class UpdateNewsDAO {
	
	private Connection con;
	private PreparedStatement ps;
	boolean flag = false;
	
	
	public UpdateNewsDAO(){
		
		con = DBConnection.createConnection();
	}
	
	
	public String insertRecord(UpdateNewsBean unbean) {
		
		String q = "insert into first_db.news values(?,?,?,?)";
		
		try {
			
			ps = con.prepareStatement(q);
			
			ps.setString(1, null);
			ps.setString(2, unbean.getNcontents());
			ps.setString(3, unbean.getDate());
			ps.setString(4, unbean.getNtype());
			
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
