<%@page import="com.chainsys.supermarketapp.model.OrderItem"%>
<%@page import="com.chainsys.supermarketapp.model.Order"%>
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

<%
Order order = (Order) request.getAttribute("ORDER_DETAILS");
//out.println(order);
%>


<table>
<thead>
<th>ProductID </th>
<th>Quantity</th>
<th>price</th>
<th>Status</th>
</tr>
</thead>

<tbody>
<%
for(OrderItem item: order.getItems()){
%>
<tr>
<td><%=item.getProductId() %>  </td>
<td><%=item.getQuantity()%></td>
<td>Rs.<%=item.getTotalAmount() %></td>
<td><%= item.getStatus() %></td>

</tr>
<%} %>
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
<td> <%= order.getOrderId() %> </td>
<td><%=order.getCustomerno() %>  </td>
<td> Rs.<%=order.getTotalAmount()%> </td>
<td>  <%=order.getOrderedDate()%></td>

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