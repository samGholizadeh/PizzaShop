<%@ include file="/WEB-INF/header.jsp" %>

<div class="row">
	<div style="margin-top: 40px;" class="col-md-4 col-md-offset-2">
		<form role="form" name="newUser" method="POST" action="register">
		    <div class="form-group">
	          <input name="username" type="text" class="form-control" id="usernameReg" placeholder="Username">
	        </div>
	        <div class="form-group">
	          <input name="email" type="email" class="form-control" id="emailInput" placeholder="Enter email">
	        </div>
	       	<div class="form-group">
	          <input name="firstname" type="text" class="form-control" id="firstnameReg" placeholder="Firstname">
	        </div>
	       	<div class="form-group">
	          <input name="lastname" type="text" class="form-control" id="lastnameReg" placeholder="Lastname">
	        </div>
	        <div class="form-group">
	          <input name="address" type="text" class="form-control" id="addressReg" placeholder="Address">
	        </div>
	       	<div class="form-group">
	          <input name="phonenumber" type="number" class="form-control" id="phonenumberReg" placeholder="Phonenumber">
	        </div>
	        <div class="form-group">
	          <input name="password" type="password" class="form-control" id="passwordReg" placeholder="Password">
	        </div>
	        <button type="submit" class="btn btn-default">Submit</button>
		</form>
	</div>
	
	<div class="col-md-4">
		<form method="POST" action="login">
		</form>
	</div>
</div>

<%@ include file="/WEB-INF/footer.jsp" %>