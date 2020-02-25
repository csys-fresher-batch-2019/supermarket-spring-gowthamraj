<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="meganta">
<center><h2>User Registration!...</h2></center>
<form action="LoginRegister"method ="post">

<pre>
						
Enter the Name         	  	 <input type="text" name="username" placeholder="username" required autofocus/><br/>
Enter the Email ID       	 <input type="email" name="mail-ID" placeholder="mail-id"><br/>
Enter the DOB			 <input type="date" name="dob" placeholder="Date of birth" ><br/>
Enter the Password               <input type="password" name="pwd" pattern=".{5,}"  placeholder="five character" required><br/>
Enter the phone number    	 <input type="number"name ="mobile number" placeholder="Mobile number" ><br/>
Gender					 <input type="radio"name=gender value="M">Male<input type="radio"name=gender value="F" >Female<br/>
				<Input type="submit" value="REGISTER">
				<a href="Login.jsp">Back to Login</a>
							<%
								String errorMessage = (String)request.getAttribute("Error-message");
								if(errorMessage !=null)
								{%>
					<font color="red"><h1>	<%= errorMessage %></h1></font>
<%} %>
</pre>
</form>
</body>
</html>