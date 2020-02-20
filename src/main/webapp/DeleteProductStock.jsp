<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="DeletePStock">
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
				<input type="submit" value="Delete Stock">
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