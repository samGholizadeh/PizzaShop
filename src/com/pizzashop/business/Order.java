package com.pizzashop.business;

import java.util.*;

public class Order extends IDClass {
	private int userId;
	private String timestamp;
	private int status;
	private double totalPrice;
	private String firstname;
	private String lastname;
	private String address;
	//Skapade både array och lista för träningsskull. Skulle funka med bara lista
	private ArrayList<Pizza> PizzaInOrder = new ArrayList<Pizza>();
	private ArrayList<Drink> DrinkInOrder = new ArrayList<Drink>();
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	public ArrayList<Pizza> getPizzaInOrder() {
		return this.PizzaInOrder;
	}
	public void setPizzaInOrder(ArrayList<Pizza> pizzaInOrder) {
		PizzaInOrder = pizzaInOrder;
	}
	public ArrayList<Drink> getDrinkInOrder() {
		return this.DrinkInOrder;
	}
	public void setDrinkInOrder(ArrayList<Drink> drinkInOrder) {
		DrinkInOrder = drinkInOrder;
	}


	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
