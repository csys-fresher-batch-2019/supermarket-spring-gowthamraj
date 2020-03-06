<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@  page import=" java.util.*"%>
<%@  page import="javax.servlet.*" %>
<html>
<head>
<title>View Bills</title>
</head>
<body >


 <pre>							
						
						
						<center>	<font color="red"><h1>GK Super Market</h1></font></center></pre>
						<c:if test="${empty sessionScope.LOGGED_IN_USER_ID}">
				    <c:redirect url = "Login.jsp"/>
				    </c:if>
			
		<center>Welcome  ${LOGGED_IN_USER_ID} ( <a href="LogoutServlet">Logout</a> )</center><br/> <br/><br/>
						
		
<table >
		<tr>
			<th>Bill No</th>
			<th>Customer Number</th>
			<th>Price</th>
			<th>Status</th>
			<th>OrderDate</th>
		</tr>	
		
		
		<tbody>

<c:forEach items="${View}" var="user">
   
	 	<tr>
       
		<td><a href= "BillItem?customer_no=${user.orderId}">${user.orderId}</a></td>
		 <td>${user.customerno}</td>
		<td>Rs.${user.totalAmount}</td>
		<td>${user.status}</td>
		<td>${user.orderedDate}</td>
	</tr>
</c:forEach>	
	</tbody>
	
	</table> 
	
<pre><center><a href="report.jsp">Back</a></center></pre>

				
</body>
</html>