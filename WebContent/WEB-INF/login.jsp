<%@ include file="/WEB-INF/header.jsp" %>
<%	
	if(session.getAttribute("order") != null){ %>
		<legend><h5><b>Login or register to continue with your order</b></h5></legend>
	<% } %>
	<div style="padding-top: 40px;" class="row">
		<div class="col-md-4 col-md-offset-2">
			<legend><h4>Register</h4></legend>
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
		        <button type="submit" class="btn btn-default">Register</button>
			</form>
		</div>
	
		<div class="col-md-4">
			<legend><h4>Login</h4></legend>
			<form role="form" method="POST" action="login">
				<div class="form-group">
					<input class="form-control" type="text" name="username" placeholder="Username"><br>
				</div>
				<div class="form-group">
					<input class="form-control" type="password" name="pw" placeholder="Password"><br>
				</div>
				<div class="form-group">
					<button class="btn btn-default" type="submit">Sign in</button>
				</div>
			</form>
		</div>
</div>
<%@ include file="/WEB-INF/footer.jsp" %>