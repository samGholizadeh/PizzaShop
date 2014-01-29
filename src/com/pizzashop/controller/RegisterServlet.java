package com.pizzashop.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pizzashop.business.User;
import com.pizzashop.business.Util;
import com.pizzashop.model.UserModel;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet({ "/RegisterServlet", "/register" })
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
			RequestDispatcher Dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/login.jsp");
			Dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		int id = UserModel.registerUser(request.getParameter("email"), request.getParameter("username"), request.getParameter("password"), request.getParameter("firstname"), request.getParameter("lastname"), request.getParameter("address"), Integer.parseInt(request.getParameter("phonenumber")));
		String url = null;
		if(id >= 0 && (session.getAttribute("order") == null)){
			User user = new User();
			user.setId(id);
			user.setEmail(request.getParameter("email"));
			user.setAdress(request.getParameter("address"));
			user.setUsername(request.getParameter("username"));
			user.setPassword(request.getParameter("password"));
			user.setFirstname(request.getParameter("firstname"));
			user.setLastname(request.getParameter("lastname"));
			user.setPhonenumber(Integer.parseInt(request.getParameter("phonenumber")));
			session.setAttribute("user", user);
			session.setAttribute("username", user.getUsername());
			url = "/WEB-INF/index.jsp";
		} else if(id >= 0 && (session.getAttribute("order") != null)){
			User user = new User();
			user.setId(id);
			user.setEmail(request.getParameter("email"));
			user.setAdress(request.getParameter("address"));
			user.setUsername(request.getParameter("username"));
			user.setPassword(request.getParameter("password"));
			user.setFirstname(request.getParameter("firstname"));
			user.setLastname(request.getParameter("lastname"));
			user.setPhonenumber(Integer.parseInt(request.getParameter("phonenumber")));
			session.setAttribute("user", user);
			session.setAttribute("username", user.getUsername());
			url = "/WEB-INF/confirmation.jsp";
		}else {
			url = "/WEB-INF/registerfail.jsp";
		}
		RequestDispatcher Dispatcher = getServletContext().getRequestDispatcher(url);
		Dispatcher.forward(request, response);
	}

}
