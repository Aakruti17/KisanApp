<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>
<%@ page import="com.db.DBConnection" %>
<%!
	Connection con;
	PreparedStatement ps;
	ResultSet rs;


%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style>

body {
  margin: 0;
  font-family: Arial, Helvetica, sans-serif;
}

.topnav {
  overflow: hidden;
  background-color: #333;
}

.topnav a {
  float: left;
  color: #f2f2f2;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
  font-size: 17px;
}

.topnav a:hover {
  background-color: #ddd;
  color: black;
}

.topnav a.active {
  background-color: #04AA6D;
  color: white;
}

* {box-sizing: border-box}
body {font-family: Verdana, sans-serif; margin:0}
.mySlides {display: none}
img {vertical-align: middle;}


#customers {
  font-family: Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

#customers td, #customers th {
  border: 1px solid #ddd;
  padding: 8px;
}

#customers tr:nth-child(even){background-color: #f2f2f2;}

#customers tr:hover {background-color: #ddd;}

#customers th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #04AA6D;
  color: white;
}
.footer {
  
   left: 0;
   bottom: 0;
   width: 100%;
   height:40px;
   background-color: #333;
   color: white;
   padding:3px;
   text-align: center;
   }
</style>
</head>
<body>

<%
	String q = "select * from first_db.products";

	con = DBConnection.createConnection();

	PreparedStatement ps = con.prepareStatement(q);
	
	ResultSet rs = ps.executeQuery();

%>


<div class="topnav" id="myTopnav">
  <a href="admin_dashboard1.html" class="active">Home</a>
  <a href="#">Farmers</a>
  <a href="view_products.jsp">Products</a>
    <a href="view_news_notifications.jsp">Latest News</a>
  <a href="add_products.jsp">Add Products</a>
  <a href="update_news.jsp">Update News</a>
   <a href="admin_login1.jsp">Logout</a>
  <a href="javascript:void(0);" class="icon" onclick="myFunction()">
    <i class="fa fa-bars"></i>
  </a>
</div>

<div style="padding-left:16px">
  <center><h2 style="color:green">KISAN</h2></center>
 
</div>

<h4>Agree Products List</h4>

<table id="customers">
  <tr>
    <th>Id</th>
    <th>Product</th>
    <th>Company</th>
    <th>Product Contents</th>
    <th>Product Price</th>
    <th>Category</th>
  </tr>
  
<%
  while(rs.next()){
%>  
	  
	  <tr>
	    <td><%= rs.getInt(1) %></td>
	    <td><%= rs.getString(2) %></td>
	    <td><%= rs.getString(3) %></td>
	    <td><%= rs.getString(4) %></td>
	    <td><%= rs.getInt(5) %></td>
	    <td><%= rs.getString(6) %></td>
	  </tr>
		
	
<%		
	}
%>
  
  
  
 
</table>
<br><br><br><br><br><br><br><br><br><br><br>
<br><br><br><br><br><br><br>

<div class="footer">
  Contact Us: +91-9922334400  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  Email Us: abcd@gmail.com
</div>





</body>
</html>