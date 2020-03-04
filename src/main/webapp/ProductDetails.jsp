<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@  page import=" java.util.*"%>
<%@  page import="javax.servlet.*"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product Details</title>
</head>
<body>
	<center>

		<pre>							
							<h1>
<b><font color="red">GK-SuperMarket</font> </b>
		
		</pre>

		<c:if test="${empty sessionScope.LOGGED_IN_USER_ID}">
			<c:redirect url="Login.jsp" />
		</c:if>

		<center>
			Welcome ${ LOGGED_IN_USER_ID} ( <a href="LogoutServlet">Logout</a> )<br />
			<br /> <br />


			<table>
				<thead>
					<tr>
						<th>Product Id</th>
						<th>Product Name</th>
						<th>Price</th>
						<th>Active</th>

					</tr>
				</thead>
				<tbody>
					<c:forEach items="${order}" var="user">

						<tr>
							<td>${user.pid}</td>
							<td>${user.productname}</td>
							<td>Rs.${user.price}</td>
							<td>${user.active}</td>
						</tr>
					</c:forEach>
			</table>
			<br>
			<pre>

		<a href="Product.jsp">Back</a>
				
</pre>

		</center>
</body>
</html>