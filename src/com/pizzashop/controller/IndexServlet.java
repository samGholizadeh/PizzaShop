package com.pizzashop.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pizzashop.business.*;
import com.pizzashop.model.*;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet("")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		String action = request.getParameter("action");
		if(action != null){
			switch(action.toLowerCase())
			{
				case "removeorder":
					System.out.println("asdad");
					int orderId = Integer.parseInt(request.getParameter("orderId"));
					OrderModel.removeOrder(orderId);
					break;
			}
		}
		String url;
		if(session.getAttribute("PizzaList") == null){
			ArrayList<Pizza> PizzaList = PizzaModel.getPizzas();
			ArrayList<Drink> DrinkList = DrinkModel.getDrinks();
			
			session.setAttribute("PizzaList", PizzaList);
			session.setAttribute("DrinkList", DrinkList);
		}
		
		if(request.getParameter("userPage") != null){
			User user = (User) session.getAttribute("user");
			int admin = user.getId();
			ArrayList<Order> orderList = null;
			if(admin == 1 || admin == 2){
				orderList = OrderModel.getOrders();
			} else {
				orderList = OrderModel.getOrders(user.getId());
			}
			session.setAttribute("orderList", orderList);
			url = "/WEB-INF/userpage.jsp";
		} else {
			url = "/WEB-INF/index.jsp";
		}
		RequestDispatcher Dispatcher = getServletContext().getRequestDispatcher(url);
		Dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		String action = request.getParameter("action");
		int orderId = 0;
		if(action != null){
			switch(action.toLowerCase())
			{
				case "removeorder":
					orderId = Integer.parseInt(request.getParameter("orderId"));
					OrderModel.removeOrder(orderId);
					break;
				case "changeorderstatus":
					System.out.println("changeOrderStatus");
					orderId = Integer.parseInt(request.getParameter("orderId"));
					OrderModel.changeOrderStatus(orderId);
					break;
			}
		}
	}

}
