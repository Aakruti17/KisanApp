<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>



<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
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

/* Slideshow container */
.slideshow-container {
  max-width: 1000px;
  position: relative;
  margin: auto;
}

/* Next & previous buttons */
.prev, .next {
  cursor: pointer;
  position: absolute;
  top: 50%;
  width: auto;
  padding: 16px;
  margin-top: -22px;
  color: white;
  font-weight: bold;
  font-size: 18px;
  transition: 0.6s ease;
  border-radius: 0 3px 3px 0;
  user-select: none;
}

/* Position the "next button" to the right */
.next {
  right: 0;
  border-radius: 3px 0 0 3px;
}

/* On hover, add a black background color with a little bit see-through */
.prev:hover, .next:hover {
  background-color: rgba(0,0,0,0.8);
}

/* Caption text */
.text {
  color: #f2f2f2;
  font-size: 15px;
  padding: 8px 12px;
  position: absolute;
  bottom: 8px;
  width: 100%;
  text-align: center;
}

/* Number text (1/3 etc) */
.numbertext {
  color: #f2f2f2;
  font-size: 12px;
  padding: 8px 12px;
  position: absolute;
  top: 0;
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

/* The dots/bullets/indicators */
.dot {
  cursor: pointer;
  height: 15px;
  width: 15px;
  margin: 0 2px;
  background-color: #bbb;
  border-radius: 50%;
  display: inline-block;
  transition: background-color 0.6s ease;
}

.active, .dot:hover {
  background-color: #717171;
}

/* Fading animation */
.fade {
  animation-name: fade;
  animation-duration: 1.5s;
}

@keyframes fade {
  from {opacity: .4} 
  to {opacity: 1}
}

/* On smaller screens, decrease text size */
@media only screen and (max-width: 300px) {
  .prev, .next,.text {font-size: 11px}
}



</style>
</head>

<body>
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

	<%
		if(session.getAttribute("status")!=null && session.getAttribute("status").equals("success")){
			
	%>
	
		<h4 style="color:green"> Product Added Successfully!</h4>
	
	<% 
		}else if(session.getAttribute("status")!=null  && session.getAttribute("status").equals("fail")){
	
	%>
	
	<h4 style="color:red"> Error!  Product Not Added</h4>
	
	<% 
		}
	
	%>

<fieldset style="width:500px;margin-top:1%;background:#26E5B1;margin-left:28%">
	
		<center><h3> Add Agree Product Details </h3></center>
		<form action="./AddProductsServlet" method="post">
			Product Name: <br><input type="text" name="pname" style="width:500px;height:30px"> <br><br>
			Company Name:<br><input type="text" name="pcompany" style="width:500px;height:30px"> <br><br>
			Contents: <br><input type="text" name="pcontents" style="width:500px;height:30px"> <br><br>
			Price: <br><input type="number" name="pprice" style="width:500px;height:30px"> <br><br>
			Category: <br>
			<select  style="width:500px;height:30px" name="pcategory">
				<option value="">Choose Product Type</option>
				<option value="fertlizer">Fertilizers</option>
				<option value="spray">Sprays</option>
				<option value="seed">Seed</option>
			
			</select> <br><br>
			
			<center><input type="submit" value="Submit" style="width:300px;height:30px;"></center>
		
		
		</form>
	
	</fieldset>


	<br>



<div class="footer">
  Contact Us: +91-9922334400  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  Email Us: abcd@gmail.com
</div>
</body>
</html>