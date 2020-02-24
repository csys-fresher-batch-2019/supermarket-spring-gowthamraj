<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Employee Details</title>
</head>
<body>
<form action="AddEmployee">
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
Enter the Employee Name	<input type=""text"" name="eno" placeholder="Employee Name" required autofocus/><br></br>
Enter the Date-Of-Birth		<input type="date" name="dob" placeholder="Date-of-birth" required autofocus/><br></br>
Enter the Date-Of-Joining	<input type="date" name="doj" placeholder="Date-of-joining" required autofocus/><br></br>
Enter the Address         	<input type="text" name="add" placeholder="Address" required autofocus/><br></br>
				<input type="submit" value="Add Employee"><br>
				<a href="Employee.jsp">Back</a>
				<%String  order = (String) request.getAttribute("AddEmployee");
%><%if(order != null) {%>

	<h2><%=order %></h2>
<%} %>			
		</pre>		
</pre>
</form>
</body>
</html>