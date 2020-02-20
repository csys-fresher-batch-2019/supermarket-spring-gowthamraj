<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Product Stock</title>
</head>
<body>
<form action="UpdatePStock">
<pre>
	
						<center>	<font color="red"><h1>GK Super Market</h1></font></center></pre>
						<%
			String username = (String) session.getAttribute("LOGGED_IN_USER_ID");
			if (username == null) {
				response.sendRedirect("Login.jsp");
			}
		%>
		<center>Welcome  <%=username%> ( <a href="LogoutServlet">Logout</a> )</center><br/> <br/><br/>
			<center>
Enter the Product Id			<input type="number" name="pno" placeholder="Product ID" required autofocus/><br><br>
Enter the quantity				<input type="number" name="qut" min="1" placeholder="Quantity" required autofocus/><br><br>
				<input type="submit" value="Updating Stock">
				<a href="ProductStock.jsp">Back</a>
				<%
String  order = (String) request.getAttribute("updateproduct");
%><%if(order != null) {%>

	<h2><%=order %></h2>
<%} %>			
				

</center>
</form>
</body>
</html>