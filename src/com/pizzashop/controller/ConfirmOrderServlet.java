package com.pizzashop.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pizzashop.business.*;
import com.pizzashop.model.OrderModel;

/**
 * Servlet implementation class ConfirmOrderServlet
 */
@WebServlet({ "/ConfirmOrderServlet", "/confirm" })
public class ConfirmOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		Order order = (Order) session.getAttribute("order");
		User user = (User) session.getAttribute("user");
		order.setUserId(user.getId());
		int insertSuccess = OrderModel.insertOrder(order.getUserId(), order.getTotalPrice(), order.getPizzaInOrder(), order.getDrinkInOrder());
		String url = "";
		if(insertSuccess >= 0){
			url = "/WEB-INF/ordersuccess.jsp";
		} else {
			url = "/WEB-INF/orderfail.jsp";
		}
		RequestDispatcher Dispatcher = getServletContext().getRequestDispatcher(url);
		Dispatcher.forward(request, response);
	}

}
