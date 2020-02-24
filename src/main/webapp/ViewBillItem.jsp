<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@  page import="com.chainsys.supermarketapp.dao.impl.BillOrderImple"%>
<%@  page import="com.chainsys.supermarketapp.model.OrderItem"%>
<%@  page import=" java.util.*"%>
<%@  page import="javax.servlet.*" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Bill Item</title>
</head>
<body>


<%
int cus=Integer.parseInt(request.getParameter("customer_no"));
BillOrderImple boi = new BillOrderImple();
List<OrderItem> list = boi.viewBillItems(cus);
 	
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
			
			<th>Bill Number</th>
			<th>Product ID</th>
			<th>Quantity</th>
			<th>Price</th>
		</tr>	
		
		
		<tbody>

		
		<%
		for (OrderItem pr : list) {
		%>
		<tr>
		
		<td><%=	pr.getOrderId() %></td>
		<td><%=pr.getProductId() %></td>
		<td><%=pr.getQuantity() %></td>
		<td>Rs.<%=pr.getTotalAmount() %></td>
		</tr>
	</tbody>
	
	<%
	}
		%>
	</table> 
	<pre><center><a href="ViewBills.jsp">Back</a></center></pre>


</body>
</html>