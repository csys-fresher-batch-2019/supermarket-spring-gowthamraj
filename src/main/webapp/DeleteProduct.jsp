<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Deleting Product</title>
</head>
<body>

<form action="DeleteProduct">
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

Enter the Product ID			<input type="number" name="pid" placeholder="Product ID" required /><br>
			
			<input type="submit" value="Delete Product">
			<a href="Product.jsp">Back</a>
			<%
String  order = (String) request.getAttribute("order");
%><%if(order != null) {%>

	<h2><%=order %></h2>
<%} %>			
</pre>
</pre>
</center>
</form>
</body>
</html>