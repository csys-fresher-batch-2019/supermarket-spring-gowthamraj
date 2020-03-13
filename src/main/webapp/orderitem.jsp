<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<%@  page import=" java.util.*"%>
<%@  page import="javax.servlet.*"%>
<html>
<head>
<title>orderItem</title>
</head>
<body bgcolor="crey">
	<form action="Bill">
		<pre>
		<center>	
		<font color="red"><h1>GK Super Market</h1></font>
			</center> </pre>
		<c:if test="${empty sessionScope.LOGGED_IN_USER_ID}">
			<c:redirect url="Login.jsp" />
		</c:if>

		Welcome ${LOGGED_IN_USER_ID} ( <a href="LogoutServlet">Logout</a> )<br />
		<br /> <br /> Enter the Customer No *: <input type="number"
			name="cusnum" required autofocus /> <br /> <br /> <br /> <br />

		<table>

			<tr>
				
				<th>Product Id</th>
				<th>Product Name</th>
				<th>Price</th>
				<th>Order</th>
				<th>Quantity</th>
			</tr>

			<c:forEach items="${order}" var="user">
				
				

					<tr>
				
						<td>${user.pid}</td>
						<td>${user.productName}</td>
						<td>Rs.${user.price}</td>
						<td><input type="checkbox" id="pid_${user.pid}" name="pid"  value="${user.pid}"></td>
						<td><input type="text" id="qty_${user.pid}" name="qty_${user.pid}"  onblur="disable(${user.pid}, this.value)" ></td>

					</tr>
			</c:forEach>
		</table>
		
		 		<pre>
		<button type="submit">Submit</button>
		<a href="report.jsp">Back</a>
				
</pre>
	</form>
	<script>
		function disable(id, qty) {
			console.log(id + "-" + qty);
			var ch = document.getElementById("pid_" + id);
			//	var qty= document.getElementById("qty_"+id).value;
			console.log("Quantity " + qty);
			if (qty && parseInt(qty) > 0) {
				console.log("Valid Qty" + qty);
			}
			if (ch.checked) {
				ch.checked = false;
			} else {
				ch.checked = true;
			}
		}
		
		function submitOrder(){
			var formData = { "customerId":1, 
					"items": [ { "itemId": 1, "quantity": 2 },
					{ "itemId": 2, "quantity": 2 }]
					};
		}
	</script>
</body>
</html>