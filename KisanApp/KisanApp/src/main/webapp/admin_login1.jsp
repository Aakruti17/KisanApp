<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<body>

<%
	if(session.getAttribute("loginstatus")!=null && session.getAttribute("loginstatus").equals("fail")){
%>

<h3 style="color:red"> Login Failed!!!!!!!!!!</h3>	
		
<%	
	}
%>



	<center><fieldset style="width:500px;text-align:center;margin-top:9%;background:#26E5B1">
	
		<center><h3> Admin Login Form </h3></center>
		<form action="./AdminLoginServlet" method="post">
			
			Email: &nbsp;&nbsp;&nbsp;&nbsp;<input type="email" name="aemail" style="width:300px"> <br><br>
			Contact: &nbsp;<input type="number" name="acontact" style="width:300px"> <br><br>
			
			<input type="submit" value="Login" style="width:200px;background:#2FC34E;border:solid blue 1px">
		
		
		</form>
	
	</fieldset></center>



</body>


</html>