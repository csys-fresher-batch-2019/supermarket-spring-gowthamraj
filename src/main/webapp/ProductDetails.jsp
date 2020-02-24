<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@  page import="com.chainsys.supermarketapp.dao.impl.ProductImple"%>
<%@  page import="com.chainsys.supermarketapp.model.Product"%>
    <%@  page import=" java.util.*"%>
<%@  page import="javax.servlet.*" %>
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> Product Details</title>
</head>
<body><center>

		<pre>							
							<h1><b><font color="red">GK-SuperMarket</font> </b>
	</pre>
			
		<%
			String username = (String) session.getAttribute("LOGGED_IN_USER_ID");
			if (username == null) {
				response.sendRedirect("Login.jsp");
			}
		%>
		Welcome  <%=username%> ( <a href="LogoutServlet">Logout</a> )<br/> <br/><br/>

<%		 
	ProductImple pi = new ProductImple();
 	List<Product> list = pi.displayproduct();
 	 %>
 			<table >
				<thead>
					<tr>
						<th>S.no</th>
						<th>Product Id</th>
						<th>Product Name</th>
						<th>Price</th>
						<th>Active</th>
						
					</tr>
				</thead>
				<tbody>
					<%
						int i = 1;
						for (Product p : list) {
					%>
					<tr>
						<td><%=(i++)%></td>
						<td><%=p.getPid()%></td>
						<td><%=p.getProductname()%></td>
						<td>Rs.<%=p.getPrice()%></td>
						<td><%=p.getActive() %>
					</tr>
					<%
						}
					%>
				</tbody>
			</table> <br>
		<pre>

		<a href="Product.jsp">Back</a>
				
</pre>

</center>
</body>
</html>