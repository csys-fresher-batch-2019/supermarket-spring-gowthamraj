<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE>
<html>
<head>
<title>Adding Product Stock</title>
</head>
<body>
	<form action="AddProductStock">
		<pre>
	
						<center>	<font color="red"><h1>GK Super Market</h1></font>
			</center>
		</pre>
		<%
			LocalDate today = LocalDate.now();
		%>
		<c:if test="${empty sessionScope.LOGGED_IN_USER_ID}">
			<c:redirect url="Login.jsp" />
		</c:if>

		<center>
			Welcome ${ LOGGED_IN_USER_ID} ( <a href="LogoutServlet">Logout</a> )
		</center>
		<br /> <br />
		<br />
		<pre>
Enter the Product Number	<input type="number" name="pno"
				placeholder="Product Number" required autofocus /><br></br>
Enter the quantity		<input type="number" name="qut"
				placeholder="Quantity" required autofocus /><br></br>
Enter the arrival date		<input type="date" name="ad"
				placeholder="Arrival Date" max="<%=today.toString()%>" required
				autofocus /><br></br>
Enter the Expery date		<input type="date" name="ed"
				placeholder="Expery Date" required autofocus /><br></br>
				<input type="submit" value="Adding Stock"><br></br>
				<a href="ProductStock.jsp">Back</a>
				
				
				<c:if test="${not empty addstock}">
		<h2>		${addstock}</h2>
				</c:if>
				
				</pre>
		</pre>
	</form>
</body>
</html>