<%@ page 
	import="com.pizzashop.business.*"
	import="java.util.*"
 %>
<%@ include file="/WEB-INF/header.jsp" %>
<%
	User user = (User) session.getAttribute("user");
	ArrayList<Order> orderList = (ArrayList<Order>) session.getAttribute("orderList");
	if(user.getId() == 1 || user.getId() == 2){
%>
      
      <div class="row">
      	<div class="col-md-12">

      		<h4>Orders</h4>
      		
     		<table class="table">
		        <thead>
			        <tr>
			            <td>Order id</td>
			            <td>Förnamn</td>
			            <td>Efternamn</td>
			            <td>Adress</td>
			            <td>Pizza</td>
			            <td>Dricka</td>
			            <td>Status</td>
			            <td></td>
			        </tr>
		        </thead>
		        <% for(int i = 0; i < orderList.size(); i++){ %>
		        	<tr id="<%= orderList.get(i).getOrderId() %>" <% if(orderList.get(i).getStatus() == 0){ %>class="warning"<% } else {%>class="success"<% } %>>
		        		<td><%= orderList.get(i).getOrderId() %></td>
		        		<td><%= orderList.get(i).getFirstname() %></td>
		        		<td><%= orderList.get(i).getLastname() %></td>
		        		<td><%= orderList.get(i).getAddress() %></td>
		        		
		        		<td>
		        			<%= orderList.get(i).getPizzaName(0) %>
		        		</td>
		        		<td><%= orderList.get(i).getDrinkName(0) %></td>
		        		
		        		<td><% if(orderList.get(i).getStatus() == 0){%><button class="btn-success btn-xs delivered">Lev.</button><%} else {%><b>Lev.</b><%} %></td>
		        		<td>
		        			<button class="btn-danger btn-xs remove">Ta bort</button>
		        		</td>
		        	</tr>
		        <% } %>
   			</table>
   		</div>
      </div>
   	<% } else { %>
   		<div class="row">
   			<div class="col-md-6">
   				<table class="table">
   					<tr>
   						<td><b>Firstname</b></td>
   						<td><%= user.getFirstname() %></td>
   					</tr>
				   	<tr>
						<td><b>Lastname</b></td>
						<td><%= user.getLastname() %></td>
					</tr>
   					<tr>
   						<td><b>Adress</b></td>
   						<td><%= user.getAdress() %></td>
   					</tr>
   					<tr>
   						<td><b>Phonenumber</b></td>
   						<td><%= user.getPhonenumber() %></td>
   					</tr>
   					<tr>
   						<td><b>E-mail</b></td>
   						<td><%= user.getEmail() %></td>
   					</tr>
   				</table>
   			</div>
   			<div class="col-md-6">
   			<table class="table">
   				<% for(int i = 0; i < orderList.size(); i++){ %>
		        	<tr <% if(orderList.get(i).getStatus() == 0){ %>class="warning"<% } else {%>class="success"<% } %>>
		        		
		        		<td><%= orderList.get(i).getPizzaName(0) %></td>
		        		<td><%= orderList.get(i).getDrinkName(0) %></td>
		        	</tr>
		        <% } %>
		        </table>
   			</div>
   		</div>
   	<% } %>
      
      
<%@ include file="/WEB-INF/footer.jsp" %>