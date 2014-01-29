<%@ page import="com.pizzashop.business.*" %>
<%@ include file="/WEB-INF/headerlog.jsp" %>
<%
	User user = (User) session.getAttribute("user");
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
			            <td>Status</td>
			            <td></td>
			        </tr>
		        </thead>
		        
   			</table>
   			
   		<% } else { %>
   			<h4>Order Pizza</h4>
   		<%} %>
   			
      	</div>
      </div>

<%@ include file="/WEB-INF/footer.jsp" %>