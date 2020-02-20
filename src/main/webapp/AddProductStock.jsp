<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE>
<html>
<head>
<title>Adding Product Stock</title>
</head>
<body>
<form action="AddProductStock">
<pre>
	
						<center>	<font color="red"><h1>GK Super Market</h1></font></center></pre>
						<%
						LocalDate today = LocalDate.now();
			String username = (String) session.getAttribute("LOGGED_IN_USER_ID");
			if (username == null) {
				response.sendRedirect("Login.jsp");
			}
		%>
		<center>Welcome  <%=username%> ( <a href="LogoutServlet">Logout</a> )</center><br/> <br/><br/>
			<pre>
Enter the Product Number	<input type="number" name="pno" placeholder="Product Number" required autofocus/><br></br>
Enter the quantity		<input type="number" name="qut" placeholder="Quantity" required autofocus/><br></br>
Enter the arrival date		<input type="date" name="ad" placeholder="Arrival Date" max="<%=today.toString()%>" required autofocus/><br></br>
Enter the Expery date		<input type="date" name="ed" placeholder="Expery Date" required autofocus/><br></br>
				<input type="submit" value="Adding Stock"><br></br>
				<a href="ProductStock.jsp">Back</a>
				<%String  order = (String) request.getAttribute("AddStock");
%><%if(order != null) {%>

	<h2><%=order %></h2>
<%} %>			
				</pre>
</pre>
</form>
</body>
</html>