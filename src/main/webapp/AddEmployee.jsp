<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
			<c:if test="${empty sessionScope.LOGGED_IN_USER_ID}">
			<c:redirect url="Login.jsp" />
		</c:if>

		<center>Welcome  ${ LOGGED_IN_USER_ID} ( <a href="LogoutServlet">Logout</a> )</center><br/> <br/><br/>
	<pre>		
Enter the Employee Name	<input type=""text"" name="eno" placeholder="Employee Name" required autofocus/><br></br>
Enter the Date-Of-Birth		<input type="date" name="dob" placeholder="Date-of-birth" required autofocus/><br></br>
Enter the Date-Of-Joining	<input type="date" name="doj" placeholder="Date-of-joining" required autofocus/><br></br>
Enter the Address         	<input type="text" name="add" placeholder="Address" required autofocus/><br></br>
				<input type="submit" value="Add Employee"><br>
				<a href="Employee.jsp">Back</a>
				
				<c:if test="${not empty AddEmployee}">
		<h2>		${AddEmployee}</h2>
				</c:if>
						</pre>		
</pre>
</form>
</body>
</html>