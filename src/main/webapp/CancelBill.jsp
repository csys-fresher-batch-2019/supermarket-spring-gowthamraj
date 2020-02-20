<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cancel Bills</title>
</head>
<body bgcolor="">
<form action="CancelBill">
<center><input type="text" name="cbills" required autofocus>
<pre>

Enter the Bill NO *:							<input type="submit" value="CANCEL"/>
									<a href="orderitem.jsp">Back To Order</a></pre></center>

				

<%
			String username = (String) session.getAttribute("cancel");
				
			if (username != null) {%>
				<h1><%=username%></h1> 
			<%}
		%>  
</form>
</body>
</html>