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
		User user = LoginModel.login(request.getParameter("username"), ("pw"));
		session.setAttribute("username", user.getUsername());
		session.setAttribute("userid", user.getId());
		String url;
		if(user == null){
			url = "/WEB-INF/loginfail.jsp";
		} else {
			url = "/WEB-INF/userpage.jsp";
		}
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
