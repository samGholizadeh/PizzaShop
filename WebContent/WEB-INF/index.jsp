<%@page import="java.util.*" import="com.pizzashop.business.*" %>
<%@include file="/WEB-INF/header.jsp" %>
<% 
	ArrayList<Pizza> PizzaList = (ArrayList<Pizza>) session.getAttribute("PizzaList");
	ArrayList<Drink> DrinkList = (ArrayList<Drink>) session.getAttribute("DrinkList");

%>

	<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
	  <!-- Indicators -->
	  <ol class="carousel-indicators">
	    <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
	    <li data-target="#carousel-example-generic" data-slide-to="1"></li>
	    <li data-target="#carousel-example-generic" data-slide-to="2"></li>
	  </ol>
	
	  <!-- Wrapper for slides -->
	  <div class="carousel-inner">
	    <div class="item active">
	      <img src="resources/img/pizzaSlide1.jpg" alt="...">
	      <div class="carousel-caption">
	        <p><b>Bästa pizzorna i stan</b></p>
	      </div>
	    </div>
	    <div class="item">
	      <img src="resources/img/pizzaSlide2.jpg" alt="...">
	      <div class="carousel-caption">
	        <p><b>Bästa pizzorna i stan</b></p>
	      </div>
	    </div>
	    <div class="item">
	      <img src="resources/img/pizzaSlide3.jpg" alt="...">
	      <div class="carousel-caption">
	        <p><b>Bästa pizzorna i stan</b></p>
	      </div>
	    </div>
	  </div>
	
	  <!-- Controls -->
	  <a class="left carousel-control" href="#carousel-example-generic" data-slide="prev">
	    <span class="glyphicon glyphicon-chevron-left"></span>
	  </a>
	  <a class="right carousel-control" href="#carousel-example-generic" data-slide="next">
	    <span class="glyphicon glyphicon-chevron-right"></span>
	  </a>
	</div>
	
	<div class="row">
		<div class="col-md-6">
			<div class="well well-sm">
				<legend><b>Meny</b></legend>
				<table class="table">
					<thead>
						<tr>
							<td>Pizza</td>
							<td>Ingredienser</td>
						</tr>
					</thead>
					<tr>
						<td>
							Margherita
						</td>
						<td>
							Tomatsås, ost
						</td>
					</tr>
					<tr>
						<td>Vesuvio</td>
						<td>Tomatsås, ost och skinka</td>
					</tr>
					<tr>
						<td>Viking</td>
						<td>Tomatsås, ost, köttfärs, räkor och sparris</td>
					</tr>
					<tr>
						<td>Kebabpizza</td>
						<td>Tomatsås, mozzarella ost, lök och kebabkött</td>
					</tr>
					<tr>
						<td>Capricciosa</td>
						<td>Tomatsås, ost, skinka och champinjoner</td>
					</tr>
				</table>
			</div>
      	</div>
      
      	<div  class="col-md-6">
      		<div class="well wellsm">
      		<legend><b>Beställ</b></legend>
      		<form method="GET" action="order">
	      	<input type="hidden" name="pizzaAmount" value="1">
	      	<input type="hidden" name="drinkAmount" value="1">
	     	 <div id="orderform" class="row">
	      		<div class="col-md-6">
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
	      			
	      		<div class="col-md-6">
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
	      </div>
     	 </div>
     </div>
     
     <div class="row">
     	<div id="jsElement" class="col-md-6">
			<input id="income" type="text" placeholder="Månadsinkomst" /><br><br>
     		<button id="calculateYearlyIncome" class="btn-small btn-primary"><b>Beräkna årsinkomst</b></button>
     	</div>
     	
     	<div class="col-md-6">
     		<button id="javaScript" class="btn btn-primary"><b>JavaScript function</b></button>
     	</div>
     </div>
      
<%@ include file="/WEB-INF/footer.jsp" %>