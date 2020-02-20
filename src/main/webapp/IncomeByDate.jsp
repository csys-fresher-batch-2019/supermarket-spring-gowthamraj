<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Income By Date</title>
</head>
<body>
<form action="IncomeByDate">
<% 
Integer amount = (Integer) request.getAttribute("billbydate");
%><pre>
<center>
		<font color="red"><h1>GK Super Market</h1>	</font>
<%
			String username = (String) session.getAttribute("LOGGED_IN_USER_ID");
			if (username == null) {
				response.sendRedirect("Login.jsp");
			}%>	Welcome <%=username%>(<a href="LogoutServlet">Logout</a> )<br/> <br/><br/>
</center>
								Enter the date *:<input type="date" name="ibd" placeholder="Date" required></br></br>
								Amount is       :<%= amount%>
											<input type ="submit" value="Check">
		
											<a href="report.jsp">Back</a>	</pre>
</form>
</body>
</html>