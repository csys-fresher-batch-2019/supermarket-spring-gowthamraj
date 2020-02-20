<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE >
<%@  page import="com.chainsys.supermarketapp.dao.impl.CaseImple"%>
<%@  page import="com.chainsys.supermarketapp.model.Employee"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Get Employee Count</title>
</head>
<body><% 
Integer order = (Integer) request.getAttribute("Total");
%><pre>
						
						
						
						
						
						<center><font color="red"><h1>GK Super Market</h1></font></center></pre>
<center>
<%
			String username = (String) session.getAttribute("LOGGED_IN_USER_ID");
			if (username == null) {
				response.sendRedirect("Login.jsp");
			}
		%>
		Welcome  <%=username%> ( <a href="LogoutServlet">Logout</a> )<br/> <br/><br/>
</center>
							
							
						
								<center>	<h3>Employee count = <%=order %></h3></br></br></br>
											<a href="report.jsp">Back</a></center>

</body>
</html>