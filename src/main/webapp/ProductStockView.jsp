<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@  page import="com.chainsys.supermarketapp.dao.impl.ProductStockImple"%>
<%@  page import="com.chainsys.supermarketapp.model.ProductStock"%>
    <%@  page import=" java.util.*"%>
<%@  page import="javax.servlet.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product Stock View</title>
</head>
<body><center>
<pre>							
							<h1><b>GK-SuperMarket </b></h1>
	</pre>
			
		<%
			String username = (String) session.getAttribute("LOGGED_IN_USER_ID");
			if (username == null) {
				response.sendRedirect("Login.jsp");
			}
		%>
		Welcome  <%=username%> ( <a href="LogoutServlet">Logout</a> )<br/> <br/><br/>

</center>
<%
ProductStockImple psi=new ProductStockImple();
List<ProductStock> p=psi.displayProductStock();
%><center>
<table >
				<thead>
					<tr>
					
						<th>S.no</th>
						<th>Product.no</th>
						<th>Stock Id</th>
						<th>Quantity</th>
						<th>Product Arrival</th>
						<th>Expery Arrival</th>
						
					</tr>
				</thead>
				<tbody>
					<%
						int i = 1;
					for (ProductStock pk : p) {
					%>
					<tr>
						<td><%=(i++)%></td>
						<td><%=pk.getProductno()%></td>
						<td><%=pk.getStockid()%></td>
						<td><%=pk.getQuantity()%></td>
						<td><%=pk.getProductarrival()%></td>
						<td><%=pk.getExperydate()%></td>
						
					</tr>
					<%
						}
					%>
				</tbody>
			</table> <br>
				<a href="ProductStock.jsp">Back</a>
		</center>		
</body>
</html>