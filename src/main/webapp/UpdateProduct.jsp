<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Product</title>
</head>
<body>

<form action="UpdateProduct">
<center>
<pre>
									
						<center>	<font color="red"><h1>GK Super Market</h1></font></center></pre>
						<%
			String username = (String) session.getAttribute("LOGGED_IN_USER_ID");
			if (username == null) {
				response.sendRedirect("Login.jsp");
			}
		%>
		<center>Welcome  <%=username%> ( <a href="LogoutServlet">Logout</a> )</center><br/> <br/><br/>
<pre>		

Enter the product Name		<input type=text name="pid" placeholder="ProductName " required /><br>

Enter the price			<input type="number" name="pri" placeholder="Price" required /><br>
			
			<input type="submit" value="Update Product">
			<a href="Product.jsp">Back</a>		
			<%
			String product=(String)request.getAttribute("product");
			%><%if(product != null) {%>
			<%=product %>
			<%} %>
</pre>
</pre>
</center>
</form>


</body>
</html>