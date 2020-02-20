<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@  page import="com.chainsys.supermarketapp.dao.impl.BillOrderImple"%>
<%@  page import="com.chainsys.supermarketapp.model.Order"%>
<%@  page import=" java.util.*"%>
<%@  page import="javax.servlet.*" %>
<html>
<head>
<title>View Bills</title>
</head>
<body >


<%
BillOrderImple boi = new BillOrderImple();
List<Order> list = boi.displayBillOrder();
 	
%>
 <pre>							
						
						
						<center>	<font color="red"><h1>GK Super Market</h1></font></center></pre>
						<%
			String username = (String) session.getAttribute("LOGGED_IN_USER_ID");
			if (username == null) {
				response.sendRedirect("Login.jsp");
			}
		%>
		<center>Welcome  <%=username%> ( <a href="LogoutServlet">Logout</a> )</center><br/> <br/><br/>
						
		
<table >
		<tr>
			<th>Bill No</th>
			<th>Customer Number</th>
			<th>Price</th>
			<th>Status</th>
			<th>OrderDate</th>
		</tr>	
		
		
		<tbody>

		
		<%
		for (Order pr : list) {
		%>
		<tr>
		
	
		
		<td><a href= "ViewBillItem.jsp?customer_no=<%=pr.getOrderId() %>"><%=pr.getOrderId() %></a></td>
		<td><%=pr.getCustomerno() %></td>
		<td>Rs.<%=pr.getTotalAmount() %></td>
		<td><%=pr.getStatus() %></td>
		<td><%=pr.getOrderedDate() %></td>
		</tr>
	</tbody>
	
	<%
	}
		%>
	</table> 
	
<pre><center><a href="report.jsp">Back</a></center></pre>

				
</body>
</html>