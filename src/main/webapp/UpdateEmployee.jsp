<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Employee Details</title>
</head>
<body>

	<form action="UpdateEmployee">
		<center>
			<pre>
									
					<c:if test="${empty sessionScope.LOGGED_IN_USER_ID}">
			<c:redirect url="Login.jsp" />
		</c:if>

		<center>Welcome  ${ LOGGED_IN_USER_ID}( <a
						href="LogoutServlet">Logout</a> )</center>
				<br /> <br /><br />
<pre>		

Enter the Employee Name			<input type="text" name="en"
						placeholder="Employee name" required /><br>

Enter the Employee Address		<input type="text" name="ea"
						placeholder="Employee Address" required /><br>
			
			<input type="submit" value="Update Employee">
			<a href="Employee.jsp">Back</a>
			
				
					<c:if test="${not empty updateproduct}">
			<h2>${updateproduct}</h2>
		</c:if>
			
</pre>
</pre>
		</center>
	</form>


</body>
</html>