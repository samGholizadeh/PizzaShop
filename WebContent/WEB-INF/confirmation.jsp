<%@page 
	import="java.util.*"
	import="com.pizzashop.business.*"
%>
<%@include file="/WEB-INF/header.jsp"%>

<% 
	Order order = (Order) session.getAttribute("order");
	User user = (User) session.getAttribute("user");
%>

<legend>Order specifications</legend>
<table class="table">
	<tr>
		<td>Pizza</td>
		<td><%= order.getPizzaInOrder().get(0).getName() %></td>
	</tr>
	<tr>
		<td>Drink</td>
		<td><%= order.getDrinkInOrder().get(0).getName() %>
	</tr>
	<tr>
		<td>Total Price</td>
		<td><%= order.getTotalPrice() %></td>
	</tr>
</table>

<legend>Ship to</legend>
<table class="table">
	<tr>
		<td>Firstname</td>
		<td><%= user.getFirstname() %></td>
	</tr>
	
	<tr>
		<td>Lastname</td>
		<td><%= user.getLastname() %></td>
	</tr>
	
	<tr>
		<td>Address</td>
		<td><%= user.getAdress() %></td>
	</tr>
	
	<tr>
		<td>Phonenumber</td>
		<td><%= user.getPhonenumber() %></td>
	</tr>
	
</table>

<form method="GET" action="confirm">
	<input type="submit" value="Confirm order">
</form>


<%@include file="/WEB-INF/footer.jsp"%>