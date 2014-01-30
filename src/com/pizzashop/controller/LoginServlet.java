package com.pizzashop.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pizzashop.model.LoginModel;
import com.pizzashop.business.*;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet({"/login" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		User user = LoginModel.login(request.getParameter("username"), request.getParameter("pw"));
		String url = null;
		if(user == null){
			url = "/WEB-INF/login.jsp";
		} else if(user != null && session.getAttribute("order") == null) {
			session.setAttribute("user", user);
			session.setAttribute("username", user.getUsername());
			url = "/WEB-INF/index.jsp";
		} else if(user != null && session.getAttribute("order") != null){
			session.setAttribute("user", user);
			session.setAttribute("username", user.getUsername());
			url = "/WEB-INF/confirmation.jsp";
		}
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}


/*Lägg till möjlighet att ta bort och lägga till pizza på menyn
 * Lägga till drink som admin
 * 
 * */
