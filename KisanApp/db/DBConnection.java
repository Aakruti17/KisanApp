package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBConnection {
	
	public static Connection con = null;
	
	public static Connection createConnection() {
	//public static void main(String[] args) {
		
		try {
			
			
			//activate the driver
			Class.forName("com.mysql.jdbc.Driver");
			
			//create connection object
			con=DriverManager.getConnection("jdbc:mysql:///first_db","root","root");
			
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;	
		
	}

}
