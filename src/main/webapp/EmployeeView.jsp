<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@  page import="com.chainsys.supermarketapp.dao.impl.EmployeeImpl"%>
<%@  page import="com.chainsys.supermarketapp.model.Employee"%>
    <%@  page import=" java.util.*"%>
<%@  page import="javax.servlet.*" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Details</title>
</head>
<body><center>
<pre>							
							<h1><b>GK-SuperMarket </b></h1>
	</pre>
			
		<%
			String username = (String) session.getAttribute("LOGGED_IN_USER_ID");
			if (username == null) {
				response.sendRedirect("Login.jsp");
			}
		%>
		Welcome  <%=username%> ( <a href="LogoutServlet">Logout</a> )<br/> <br/><br/>

</center>
<%EmployeeImpl ei=new EmployeeImpl();

List <Employee>ee=ei.displayEmployeeDetils();
%><center>
<table >
				<thead>
					<tr>
					
						<th>S.no</th>
						<th>Employee ID</th>
						<th>Employee Name</th>
						<th>Date Of Birth</th>
						<th>Date Of Joining</th>
						<th>Adddress</th>
						
					</tr>
				</thead>
				<tbody>
					<%
						int i = 1;
					for (Employee emp : ee) {
					%>
					<tr>
						<td><%=(i++)%></td>
						<td><%=emp.getEmployeeid()%></td>
						<td><%=emp.getEmployeename()%></td>
						<td><%=emp.getDob()%></td>
						<td><%=emp.getDoj()%></td>
						<td><%=emp.getAddress()%></td>
						
					</tr>
					<%
						}
					%>
				</tbody>
			</table> <br>
				<a href="Employee.jsp">Back</a>
		</center>		
</body>
</html>