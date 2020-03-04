<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@  page
	import="com.chainsys.supermarketapp.dao.impl.ProductStockImple"%>
<%@  page import="com.chainsys.supermarketapp.model.ProductStock"%>
<%@  page import=" java.util.*"%>
<%@  page import="javax.servlet.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product Stock View</title>
</head>
<body>
	<center>
		<pre>							
							<h1>
<b>GK-SuperMarket </b>
			</h1>
	</pre>
		<c:if test="${empty sessionScope.LOGGED_IN_USER_ID}">
			<c:redirect url="Login.jsp" />
		</c:if>

		<center>
			Welcome ${ LOGGED_IN_USER_ID} ( <a href="LogoutServlet">Logout</a> )<br />
			<br />
			<br />

		</center>
		
		<center>
			<table>
				<thead>
					<tr>

		
						<th>Product.no</th>
						<th>Stock Id</th>
						<th>Quantity</th>
						<th>Product Arrival</th>
						<th>Expery Arrival</th>

					</tr>
				</thead>
				<tbody>
		
			<c:forEach items="${order}" var="user">
		
					<tr>
						
						<td>${user.productno}</td>
						<td>${user.stockid}</td>
						<td>${user.quantity}</td>
						<td>${user.productarrival}</td>
						<td>${user.experydate}</td>

					</tr>
		</c:forEach>
		
				</tbody>
			</table>
			<br> <a href="ProductStock.jsp">Back</a>
		</center>
</body>
</html>