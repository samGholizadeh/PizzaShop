<%@page import="java.util.*" import="com.pizzashop.business.*" %>
<%@include file="/WEB-INF/header.jsp" %>
<% 
	ArrayList<Pizza> PizzaList = (ArrayList<Pizza>) session.getAttribute("PizzaList");
	ArrayList<Drink> DrinkList = (ArrayList<Drink>) session.getAttribute("DrinkList");

%>
      <div id="orderform" class="row">
      	<div class="col-md-6 col-md-offset-1">
      		<form method="POST" action="order">
      			<table class="table">
      				<thead>
      					<tr>
      						<td>Pizza</td>
      						<!-- <td>Pizza #2</td>
      						<td>Pizza #3</td>
      						<td>Pizza #4</td> -->
      						<td>Drink</td>
      					</tr>
      				</thead>
      				
      				<tr>
      				<%--  <% for(int i = 0; i < PizzaList.size(); i++){ %> --%>
      					<td>
      						<select name="pizzaid">
      						  	<% for(Iterator<Pizza> p = PizzaList.iterator(); p.hasNext();){
   									Pizza pizza = p.next();%>
      								<option value="<%= pizza.getId() %>"><%= pizza.getName() %></option>
      							<% } %>
      						</select>
      					</td>
      					<td>
	      					<select name="drinkid">
	      						<% for(Iterator<Drink> d = DrinkList.iterator(); d.hasNext();){
	      							Drink drink = d.next(); %>
	      							<option value="<%= drink.getId() %>"><%= drink.getName() %>&nbsp;&nbsp;<%= drink.getPrice() %>kr</option>
	      						<% } %>
	      					</select>
      					</td>
      				<%-- <% } %> --%>
      				</tr>
      				
      				<tr>
      				</tr>
      			</table>
      			<input type="submit" value="Beställ">	
      		</form>
      	</div>
      </div>
      
<%@ include file="/WEB-INF/footer.jsp" %>