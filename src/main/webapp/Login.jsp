<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<title>Login</title>
</head>
<body bgcolor="cyan">
<img src="assets/images/sp.jpg" style="width:100%" style="height=80%">

<center>
<h2> GK-Super Market</h2>
<h3>LOGIN</h3>
</center>
<form action="Login"method="post">
<pre>
					Enter the UserName    <Input type="text"name="uname"  placeholder ="Enter username" required autofocus/><br/></n>

					Enter the PassWord    <Input type="password" name="pword" pattern=".{5,}"  placeholder ="Five or more characters" required autofocus/><br/>
								<Input type="submit" value="login">
								<a href ="NewUserRegistration.jsp"> Sign-in..</a>
								<h1>${LOGGED_IN_USER_ID}</h1>
								
</pre>			

</form>
</body>
</html>
