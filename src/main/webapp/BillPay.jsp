<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>payment</title>
</head>
<body >
<pre> <center><h1>PAyMENT SuCCESFUL</h1></center>
<%
String order = (String) request.getAttribute("ORDER_DETAILS");
//out.println(order);
%>
<%=order %>
	<a href="orderitem.jsp"> <img src = "assets/images/welcome.jpg" style="width:50%" style="height=50%" ></a>
</pre>
</body>
</html>