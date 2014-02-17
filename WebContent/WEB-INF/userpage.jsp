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
		        	<tr id="<%= orderList.get(i).getId() %>" <% if(orderList.get(i).getStatus() == 0){ %>class="warning"<% } else {%>class="success"<% } %>>
		        		<td><%= orderList.get(i).getId() %></td>
		        		<td><%= orderList.get(i).getFirstname() %></td>
		        		<td><%= orderList.get(i).getLastname() %></td>
		        		<td><%= orderList.get(i).getAddress() %></td>
		        		
		        		<td>
		        			<select>
		        			<% for(int k = 0; k < orderList.get(i).getPizzaInOrder().size(); k++){ %>
		        				<option><%= orderList.get(i).getPizzaInOrder().get(k).getName() %></option>
		        			<% } %>
		        			</select>
		        		</td>
		        		<td>
		        			<select>
			        			<% for(int k = 0; k < orderList.get(i).getDrinkInOrder().size(); k++){ %>
			        				<option><%= orderList.get(i).getDrinkInOrder().get(k).getName() %></option>
			        			<% } %>
		        			</select>
		        		</td>
		        		
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
   				<h4><b>Dina uppgifter</b></h4>
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
   			<h4><b>Orders</b></h4>
   			<table class="table">
   				<thead>
   					<tr>
   						<td>Pizza(s)</td>
   						<td>Drink(s)</td>
   					</tr>
   				</thead>
   				<% for(int i = 0; i < orderList.size(); i++){ %>
		        	<tr <% if(orderList.get(i).getStatus() == 0){ %>class="warning"<% } else {%>class="success"<% } %>>
		        		<td>
		        			<select>
		        			<% for(int k = 0; k < orderList.get(i).getPizzaInOrder().size(); k++){ %>
		        				<option><%= orderList.get(i).getPizzaInOrder().get(k).getName() %></option>
		        			<% } %>
		        			</select>
		        		</td>
		        		<td>
		        			<select>
			        			<% for(int k = 0; k < orderList.get(i).getDrinkInOrder().size(); k++){ %>
			        				<option><%= orderList.get(i).getDrinkInOrder().get(k).getName() %></option>
			        			<% } %>
		        			</select>
		        		</td>
		        	</tr>
		        <% } %>
		        </table>
   			</div>
   		</div>
   		<div class="row">
   			<div class="col-md-6">
   				<form method="get" action="?action=search">
   					<input type="hidden" name="userPage" value="true">
   					<input type="hidden" name="action" value="search">
   					<input type="text" name="searchString" placeholder="Pizza name">
   					<input type="hidden" name="userId" value="<%= user.getId()%>">
   					<input type="submit" value="Search">
   				</form>
   			</div>
   			<div class="col-md-6">
   				<% 
   				SearchClass sc = (SearchClass) session.getAttribute("SearchClass");
   				if(SearchClass.containsResult){ %>
   					<h3><b>Number of <%= sc.searchString%> ordered: <%= sc.count%></b></h3>
   				<% SearchClass.containsResult = false; } %>
   			</div>
   		</div>
   	<% } %>
<%@ include file="/WEB-INF/footer.jsp" %>