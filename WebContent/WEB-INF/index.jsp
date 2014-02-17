<%@page import="java.util.*" import="com.pizzashop.business.*" %>
<%@include file="/WEB-INF/header.jsp" %>
<% 
	ArrayList<Pizza> PizzaList = (ArrayList<Pizza>) session.getAttribute("PizzaList");
	ArrayList<Drink> DrinkList = (ArrayList<Drink>) session.getAttribute("DrinkList");

%>
      <form method="GET" action="order">
      	<input type="hidden" name="pizzaAmount" value="1">
      	<input type="hidden" name="drinkAmount" value="1">
     	 <div id="orderform" class="row">
      		<div class="col-md-3 col-md-offset-1">
      			<table id="pizzaTable" class="table">
      				<thead>
      					<tr>
      						<td>
      							Pizza&nbsp; &nbsp;Antal: &nbsp;
      							<select id="pizzaAmount">
      								<option selected="selected" value="1">1</option>
      								<option value="2">2</option>
      								<option value="3">3</option>
      								<option value="4">4</option>
      								<option value="5">5</option>
      							</select>
      						</td>
      					</tr>
      				</thead>
      				
      				<tr id="pizzaTemplate">
      					<td>
      						<select name="pizzaid1">
      						  	<% for(Iterator<Pizza> p = PizzaList.iterator(); p.hasNext();){
   									Pizza pizza = p.next();%>
      								<option value="<%= pizza.getId() %>"><%= pizza.getName() %>&nbsp;&nbsp; <%= pizza.getPrice() %></option>
      							<% } %>
      						</select>
      					</td>
      				</tr>
      				
      			</table>
      			</div>
      			<div class="col-md-3">
      			<table id="drinkTable" class="table">
      				<thead>
      					<tr>
				      		<td>Drink&nbsp;&nbsp;Antal:&nbsp;
								<select id="drinkAmount">
									<option selected="selected" value="1">1</option>
									<option value="2">2</option>
									<option value="3">3</option>
									<option value="4">4</option>
									<option value="5">5</option>
								</select>
							</td>
						</tr>
					</thead>
						<tr id="drinkTemplate">
							<td>
		      					<select name="drinkid1">
		      						<% for(int i = 0; i < DrinkList.size(); i++){%>
		      							<option value="<%= DrinkList.get(i).getId() %>"><%= DrinkList.get(i).getName() %>&nbsp;&nbsp;<%= DrinkList.get(i).getPrice() %>kr</option>
		      						<% } %>
		      					</select>
		      				</td>
		     			</tr>
      				</table>
      			</div>
      		</div>
      	<input type="submit" value="Beställ">
      </form>
      
<%@ include file="/WEB-INF/footer.jsp" %>