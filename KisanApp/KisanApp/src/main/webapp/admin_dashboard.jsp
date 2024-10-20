<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.Connection"%> 
<%@ page import="java.sql.PreparedStatement"%> 
<%@ page import="java.sql.ResultSet"%> 
<%@ page import="com.db.DBConnection"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%!
		//declaration tag of jsp so just declare variables here
		Connection con;
		PreparedStatement ps;
		ResultSet rs;
		
		private static final String q = "select * from first_db.admin_info";
	
	%>
	
	
	<%
	
		con=DBConnection.createConnection();
		ps = con.prepareStatement(q);
		
		ps = con.prepareStatement(q);
		
		rs = ps.executeQuery();
		
		while(rs.next()) {
	%>	
		
		<h3>
		
		 <%= rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getInt(4)+"\t"+rs.getString(5) %>
		
		</h3>
		
		
		
	<%	
		}
		
	%>
	



</body>
</html>