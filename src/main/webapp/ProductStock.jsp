<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product Stock Details</title>
</head>

<body bgcolor="#DAF7A6">
	<pre>


					<center>		<font color="red"><h1>GK Super Market</h1>		</font>				
<c:if test="${empty sessionScope.LOGGED_IN_USER_ID}">
			<c:redirect url="Login.jsp" />
		</c:if>

		<center>Welcome  ${ LOGGED_IN_USER_ID}( <a href="LogoutServlet">Logout</a> )<br /> <br /><br />
			</center>
	
<center>
<h2>
<a href="ProductStockView">View Product Stock</a>

<a href="AddProductStock.jsp">Add Products Stock</a>

<a href="UpdateProductStock.jsp">Update product Stock</a>



<a href="report.jsp">Back </a>

</h2>
</center>


</body>
</html>