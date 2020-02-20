<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Total Amount</title>
</head>
<body>
<pre>
<%
int a=(Integer)request.getAttribute("total");
%><pre>
						
						
						
						
						
						<center><font color="red"><h1>GK Super Market</h1></font></center></pre>
<%
			String username = (String) session.getAttribute("LOGGED_IN_USER_ID");
			if (username == null) {
				response.sendRedirect("Login.jsp");
			}%><center>Welcome  <%=username%> ( <a href="LogoutServlet">Logout</a> )</center><br/>

								<center><h3>Total Income is :<%=a %></h3>
<a href="report.jsp" >Back</a></center>


</body>
</html>