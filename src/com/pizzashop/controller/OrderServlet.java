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

/**
 * Servlet implementation class OrderServlet
 */
@WebServlet({ "/OrderServlet", "/order" })
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		
		Order order = new Order();
		Pizza pizza = new Pizza();
		Drink drink = new Drink();
		double totalPrice = 0;
		ArrayList<Pizza> PizzaList = (ArrayList<Pizza>) session.getAttribute("PizzaList");
		ArrayList<Drink> DrinkList = (ArrayList<Drink>) session.getAttribute("DrinkList");
		for(int i = 0; i < PizzaList.size(); i++){
			if(PizzaList.get(i).getId() == Integer.parseInt(request.getParameter("pizzaid"))){
				pizza.setName(PizzaList.get(i).getName());
				pizza.setPrice(PizzaList.get(i).getPrice());
				pizza.setId(Integer.parseInt(request.getParameter("pizzaid")));
				totalPrice += PizzaList.get(i).getPrice();
				order.getPizzaInOrder().add(pizza);
			}
		}
		for(int i = 0; i < DrinkList.size(); i++){
			if(DrinkList.get(i).getId() == Integer.parseInt(request.getParameter("drinkid"))){
				drink.setName(DrinkList.get(i).getName());
				drink.setPrice(DrinkList.get(i).getPrice());
				drink.setId(Integer.parseInt(request.getParameter("drinkid")));
				totalPrice += DrinkList.get(i).getPrice();
				order.getDrinkInOrder().add(drink);
			}
		}
		order.setTotalPrice(totalPrice);
		session.setAttribute("order", order);
		
		if(session.getAttribute("user") == null){
			session.setAttribute("orderTrue", true);
			RequestDispatcher Dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/login.jsp");
			Dispatcher.forward(request,  response);
		} else {
			User user = (User) session.getAttribute("user");
			RequestDispatcher Dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/confirmation.jsp");
			Dispatcher.forward(request,  response);
		}
		
		
		/*ArrayList<Pizza> PizzaList = (ArrayList<Pizza>) request.getAttribute("PizzaList");
		ArrayList<Drink> DrinkList = (ArrayList<Drink>) session.getAttribute("DrinkList");
		
		for(int i = 0; i < PizzaList.size(); i++){
			if(PizzaList.get(i).getId() == pizzaid){
				Pizza pizza = new Pizza();
				pizza.set
			}
		}*/
	}
}
