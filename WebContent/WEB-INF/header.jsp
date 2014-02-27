<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->
	<head>
		<meta charset="utf-8">
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Pizza butik</title>
		
		<link rel="stylesheet" type="text/css" href="resources/css/bootstrap.css">
		<link rel="stylesheet" type="text/css" href="resources/css/bootstrap-theme.css">
		<link rel="stylesheet" type="text/css" href="resources/css/homecooked.css">
		<link rel="stylesheet" type="text/css" href="resources/css/narrow-jumbotrn.css">
		
		<style>
			.container{
				margin-top: 10px;
				width: 860px;
			}
			.header{
				margin-bottom: 25px;
			}
		</style>
		
	</head>
 <body>
 	<div class="container">
	<% if(session.getAttribute("user") == null){ %>
      <div class="header">
	      <form id="navbarform" class="navbar-form navbar-right" method="POST" action="login" class="form-inline" role="form">
	        <div class="form-group">
	          <label class="sr-only" for="exampleInputEmail2">Email address</label>
	          <input type="text" name="username" class="form-control" id="exampleInputEmail2" placeholder="Username">
	        </div>
	        <div class="form-group">
	          <label class="sr-only" for="exampleInputPassword2">Password</label>
	          <input type="password" name="pw" class="form-control" id="exampleInputPassword2" placeholder="Password">
	        </div>
	        <button type="submit" class="btn btn-default">Sign in</button>
	        
	      </form>
        <a href="../PizzaShop/"><img style="height: 80px; width: 120px;" src="resources/img/logo.png"></a>
      </div>
      <% } else { %>
      <div class="header">
		    <div class="btn-group navbar-form navbar-right pull-right">
		      <button type="button" class="btn btn-success dropdown-toggle" data-toggle="dropdown"><b><%= session.getAttribute("username") %></b> <span class="caret"></span></button>
			      <ul class="dropdown-menu" role="menu">
			        <li><a href="../PizzaShop/?userPage=true">User page</a></li>
			        <li class="divider"></li>
			        <li><a href="logout">Logout</a></li>
			      </ul>
		    </div>
        	 <a href="../PizzaShop/"><img style="height: 80px; width: 120px;" src="resources/img/logo.png"></a>
      </div>
      <% } %>