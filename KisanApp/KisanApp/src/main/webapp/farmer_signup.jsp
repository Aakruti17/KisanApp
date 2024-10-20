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
	if(session.getAttribute("signupstatus")!=null && session.getAttribute("signupstatus").equals("fail")){
%>

<h3 style="color:red"> Login Failed!!!!!!!!!!</h3>	
		
<%	
	}
%>

	<center><fieldset style="width:500px;text-align:center;margin-top:9%;background:#26E5B1">
	
		<center><h3> Farmer Signup Form </h3></center>
		
		<form action="./FarmerSignupServlet" method="post">
			Name: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="fname" style="width:300px"> <br><br>
			Contact: &nbsp;&nbsp;&nbsp;&nbsp;<input type="number" name="fcontact" style="width:300px"> <br><br>
			Village: &nbsp;<input type="text" name="fvillage" style="width:300px"> <br><br>
			Username: &nbsp;<input type="text" name="funame" style="width:300px"> <br><br>
			Password: &nbsp;<input type="password" name="fpwd" style="width:300px"> <br><br>
			<input type="submit" value="signup" style="width:200px;background:#2FC34E;border:solid blue 1px">
		
		
		</form>
	
	</fieldset></center>




</body>
</html>