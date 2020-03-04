<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Adding Products</title>
</head>
<body>
	<form action=AddProduct>
		<center>
			<pre>
									
						<center>	<font color="red"><h1>GK Super Market</h1></font>
				</center>
			</pre>
			<c:if test="${empty sessionScope.LOGGED_IN_USER_ID}">
				<c:redirect url="Login.jsp" />
			</c:if>

			<center>
				Welcome ${LOGGED_IN_USER_ID } ( <a href="LogoutServlet">Logout</a> )
			</center>
			<br /> <br /> <br />
			<pre>		

Enter the Product name			<input type="text" name="pno"
					placeholder="Product Name" required /><br>

Enter the price				<input type="number" name="pri" placeholder="Price"
					required /><br>
			
			<input type="submit" value="Add Product">
			<a href="Product.jsp">Back</a>
			<c:if test="${not empty addproduct}">
		<h2>		${addproduct}</h2>
				</c:if>
				</pre>
			</pre>
		</center>
	</form>
</body>
</html>