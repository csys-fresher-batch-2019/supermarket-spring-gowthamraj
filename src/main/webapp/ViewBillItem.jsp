<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@  page import="com.chainsys.supermarketapp.dao.impl.BillOrderDAOImpl"%>
<%@  page import="com.chainsys.supermarketapp.model.OrderItem"%>
<%@  page import=" java.util.*"%>
<%@  page import="javax.servlet.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Bill Item</title>
</head>
<body>

	<pre>							
						<center>	<font color="red"><h1>GK Super Market</h1></font>
		</center>
	</pre>
	<c:if test="${empty sessionScope.LOGGED_IN_USER_ID}">
		<c:redirect url="Login.jsp" />
	</c:if>

	<center>
		Welcome ${ LOGGED_IN_USER_ID} ( <a href="LogoutServlet">Logout</a> )
	</center>
	<br />
	<br />
	<br />


	<table>
		<tr>

			<th>Bill Number</th>
			<th>Product ID</th>
			<th>Quantity</th>
			<th>Price</th>
		</tr>


		<tbody>

	<c:forEach items="${billitem}" var="user">
			
			<tr>

				<td>${user.orderId}</td>
				<td>${user.productId}</td>
				<td>${user.quantity}</td>
				<td>Rs.${user.totalAmount}</td>
			</tr>
</c:forEach>
		</tbody>

	</table>
	<pre>
		<cen>
			<a href="ViewBills">Back</a>
		</center>
	</pre>


</body>
</html>