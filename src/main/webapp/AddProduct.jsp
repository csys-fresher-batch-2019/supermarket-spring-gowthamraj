<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Adding Products</title>
</head>
<body>
<form action=AddProduct>
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

Enter the Product name			<input type="text" name="pno" placeholder="Product Name" required /><br>

Enter the price				<input type="number" name="pri" placeholder="Price" required /><br>
			
			<input type="submit" value="Add Product">
			<a href="Product.jsp">Back</a><%
String  order = (String) request.getAttribute("addproduct");
%><%if(order != null) {%>

	<h2><%=order %></h2>
<%} %>			
</pre>
</pre>
</center>
</form>
</body>
</html>