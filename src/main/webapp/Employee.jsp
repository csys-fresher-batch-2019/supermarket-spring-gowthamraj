<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Details</title>
</head>
<body bgcolor="#DAF7A6">
<pre>


					<center>		<font color="red"><h1>GK Super Market</h1>		</font>				
<%
			String username = (String) session.getAttribute("LOGGED_IN_USER_ID");
			if (username == null) {
				response.sendRedirect("Login.jsp");
			}
		%>
	Welcome  <%=username%> ( <a href="LogoutServlet">Logout</a> )<br/> <br/><br/></center>
	
<center>
<h2>
<a href ="EmployeeView.jsp">View Employee Details</a>

<a href ="AddEmployee.jsp">Add Employee</a>

<a href="UpdateEmployee.jsp">Update Employee </a>

<a href="DeleteEmployee.jsp">Delete Employee </a>

<a href="report.jsp">Back </a>

</h2>
</center>

</body>
</html>