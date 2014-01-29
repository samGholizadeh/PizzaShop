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
		
		<style>
			.container{
				margin-top: 10px;
			}
			.header{
				margin-bottom: 25px;
			}
			
			
		</style>
		
	</head>
 <body>
	<% if(session.getAttribute("user") == null){ %>
    <div class="container">
      <div class="header">
        <ul class="nav nav-pills pull-right">
	      <form method="POST" action="login" class="form-inline" role="form">
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
	      <a href="register"><b>Registrera</b></a>
        </ul>
        <h3>Pizza butiken</h3>
      </div>
      <% } else { %>
          <div class="container">
      <div class="header">
        <ul class="nav nav-pills pull-right">
        	<div class="navbar-collapse collapse">
        	
        	<form method="GET" action="../PizzaShop/">
        		<input type="hidden" name="userPage" value="true">
        		<button class="btn btn-success"><%= session.getAttribute("username") %></button>
        	</form>
	          <form method="GET" action="logout" class="navbar-form navbar-right" role="form">
	            <button type="submit" class="btn btn-success">Logout</button>
	          </form>
        	</div>
        </ul>
        <h3>Pizza butiken</h3>
      </div>
      <% } %>