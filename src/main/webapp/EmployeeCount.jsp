<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Get Employee Count</title>
</head>
<body>
	<pre>
						<center>
			<font color="red"><h1>GK Super Market</h1></font>
		</center>
	</pre>
	<center>
		<c:if test="${empty sessionScope.LOGGED_IN_USER_ID}">
			<c:redirect url="Login.jsp" />
		</c:if>

		<center>
			Welcome ${ LOGGED_IN_USER_ID} ( <a href="LogoutServlet">Logout</a> )<br />
			<br /> <br />
		</center>



		<center>
			<h3>Employee count = ${Total}</h3>
			</br> </br> </br> <a href="report.jsp">Back</a>
		</center>
</body>
</html>