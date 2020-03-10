<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@  page import=" java.util.*"%>
<%@  page import="javax.servlet.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Details</title>
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

						<th>Employee ID</th>
						<th>Employee Name</th>
						<th>Date Of Birth</th>
						<th>Date Of Joining</th>
						<th>Adddress</th>

					</tr>
				</thead>
				<tbody>
		<c:forEach items="${order}" var="user">
		
					<tr>
						<td>${user.employeeId}</td>
						<td>${user.employeeName}</td>
						<td>${user.dob}</td>
						<td>${user.doj}</td>
						<td>${user.address}</td>

					</tr>
				</c:forEach>
				</tbody>
			</table>
			<br> <a href="Employee.jsp">Back</a>
		</center>
</body>
</html>