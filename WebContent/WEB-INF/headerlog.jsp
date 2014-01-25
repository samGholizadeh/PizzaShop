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
		
		<style>
			.container{
				margin-top: 60px;
			}
		</style>
		
	</head>
	  <body>
	
    <div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
      
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">Project name</a>
        </div>
        	<div class="navbar-collapse collapse">
        	<button class="btn btn-success"><%= session.getAttribute("username") %></button>
	          <form method="GET" action="logout" class="navbar-form navbar-right" role="form">
	            <button type="submit" class="btn btn-success">Logout</button>
	          </form>	
        	
        	</div>
      	
    </div>
    
    <div class="container">