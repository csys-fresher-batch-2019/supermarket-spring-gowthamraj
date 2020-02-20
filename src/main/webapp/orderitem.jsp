<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@  page import="com.chainsys.supermarketapp.dao.impl.ProductImple"%>
<%@  page import="com.chainsys.supermarketapp.model.Product"%>
<%@  page import=" java.util.*"%>
<%@  page import="javax.servlet.*" %>
<html>
<head>
<title>orderItem</title>
</head>
<body bgcolor="crey">
	<form action="Bill">

		<pre>							
							<b>GK-SuperMarket </b>
	</pre>
			
		<%
			String username = (String) session.getAttribute("LOGGED_IN_USER_ID");
			if (username == null) {
				response.sendRedirect("Login.jsp");
			}
		%>
		Welcome  <%=username%> ( <a href="LogoutServlet">Logout</a> )<br/> <br/><br/>

Enter the Customer No *: <input type="number" name="cusnum" required autofocus/> <br/><br/> <br/><br/>
<%		 
	ProductImple pi = new ProductImple();
 	List<Product> list = pi.displayproductAvailable();
 	 %>
 			<table >
				<thead>
					<tr>
						<th>S.no</th>
						<th>Product Id</th>
						<th>Product Name</th>
						<th>Price</th>
						<th>Order</th>
						<th>Quantity</th>
					</tr>
				</thead>
				<tbody>
					<%
						int i = 1;
						for (Product p : list) {
					%>
					<tr>
						<td><%=(i++)%></td>
						<td><%=p.getPid()%></td>
						<td><%=p.getProductname()%></td>
						<td>Rs.<%=p.getPrice()%></td>
						<td><input type="checkbox" id="pid_<%=p.getPid()%>" name="pid"  value="<%=p.getPid()%>"></td>
						<td><input type="text" id="qty_<%=p.getPid()%>" name="qty_<%=p.getPid()%>"  onblur="disable(<%=p.getPid()%>, this.value)" ></td>

					</tr>
					<%
						}
					%>
				</tbody>
			</table> <br>
		<pre>
		<button type="submit">Submit</button>
		<a href="report.jsp">Back</a>
				
</pre>
	</form>
	<script>
	
function disable(id,qty)
{
  console.log(id + "-" + qty);
	var ch= document.getElementById("pid_"+id);
//	var qty= document.getElementById("qty_"+id).value;
	console.log("Quantity " + qty);
	if (qty && parseInt(qty) > 0){
		console.log("Valid Qty" + qty);
	}
	if(ch.checked)
		{
		ch.checked=false;
	}
	else
		{
		ch.checked=true;
		}
}
	</script>
</body>
</html>