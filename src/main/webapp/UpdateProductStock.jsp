<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Product Stock</title>
</head>
<body>
	<form action="UpdatePStock">
		<pre>
	
						<center>	<font color="red"><h1>GK Super Market</h1></font>
			</center>
		</pre>
		<c:if test="${empty sessionScope.LOGGED_IN_USER_ID}">
			<c:redirect url="Login.jsp" />
		</c:if>

		<center>
			Welcome ${ LOGGED_IN_USER_ID}( <a href="LogoutServlet">Logout</a> )
		</center>
		<br /> <br />
		<br />
		<center>
			Enter the Product Id <input type="number" name="pno"
				placeholder="Product ID" required autofocus /><br>
			
			<br> Enter the quantity <input type="number" name="qut" min="1"
				placeholder="Quantity" required autofocus /><br>
			
			<br> <input type="submit" value="Updating Stock"> <a
				href="ProductStock.jsp">Back</a>
				
						<c:if test="${not empty updateproduct}">
			<h2>${updateproduct}</h2>
		</c:if>
			
		</center>
	</form>
</body>
</html>