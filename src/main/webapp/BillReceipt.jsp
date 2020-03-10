<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bill Receipt</title>
<style>
table {
  width: 23%;
}

td{
	width:55%;
}
</style>
</head>
<body bgcolor="#85C1E9">

<form action="BillPayment">
<center><h1>* Gk SuperMarket *</h1></center>
<center><h2>* Bills *</h2></center>




<table>
<thead>
<tr>
<th>ProductID </th>
<th>Quantity</th>
<th>price</th>
<th>Status</th>
</tr>
</thead>

<tbody>


<c:forEach items="${ORDER_DETAILS.items}" var="item">
<tr>
<td>${item.productId}  </td>
<td>${item.quantity}</td>
<td>Rs.${item.totalAmount }</td>
<td>${item.status}</td>

</tr>
</c:forEach>
</tbody>
</table>
</br>
</br>
<table>
<thead>
<tr><th>Bill NO</th>
<th>Customer Number</th>
<th>Total Amount</th>
<th>orderedDate</th></tr>
</thead>
<tbody>
<tr>
<td>${ORDER_DETAILS.orderId} </td>
<td>${ORDER_DETAILS.customerNo}</td>
<td>Rs.${ORDER_DETAILS.totalAmount} </td>
<td>${ORDER_DETAILS.orderedDate}</td>

</tr>
</tbody>
</table>

<pre>						<button type="submit" value="Submit">pay</button></br>
							<a href="CancelBill.jsp">Cancel bill</a>
							<a href="orderitem.jsp">back</a>
</pre>
</form>
</body>
</html>