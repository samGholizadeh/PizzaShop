<%@ include file="/WEB-INF/headerlog.jsp" %>

      <div class="jumbotron">
      </div>
      
      <div class="row">
      	<div class="col-md-12">
      	
      	<%if(session.getAttribute("userid") == 1 || session.getAttribute("userid") == 2){ %>
      		<h4>Orders</h4>
      		
     		<table class="table">
		        <thead>
			        <tr>
			            <td>Order id</td>
			            <td>Förnamn</td>
			            <td>Efternamn</td>
			            <td>Adress</td>
			            <td>Status</td>
			        </tr>
		        </thead>
   			</table>
   			
   		<% } else { %>
   			<h4>Order Pizza</h4>
   		<%} %>
   			
      	</div>
      </div>

<%@ include file="/WEB-INF/footer.jsp" %>