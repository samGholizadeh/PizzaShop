package com.pizzashop.business;

import java.util.*;

public class Order {
	private int orderId;
	private int userId;
	private String timestamp;
	private int status;
	private double totalPrice;
	private String firstname;
	private String lastname;
	private String address;
	//Skapade både array och lista för träningsskull. Skulle funka med bara lista
	private String[] pizzaNames;
	private String[] drinkNames;
	private ArrayList<Pizza> PizzaInOrder = new ArrayList<Pizza>();
	private ArrayList<Drink> DrinkInOrder = new ArrayList<Drink>();
	
	public void initializePizzaNames(int elements){
		pizzaNames = new String[elements];
	}
	
	public void initializeDrinkNames(int elements){
		drinkNames = new String[elements];
	}
	
	public void setPizzaName(int element, String pizzaName){
		pizzaNames[element] = pizzaName;
	}
	
	public void setDrinkName(int element, String drinkName){
		drinkNames[element] = drinkName;
	}
	
	public String getPizzaName(int element){
		System.out.println("pizzaName array length"+pizzaNames.length);
		return this.pizzaNames[element];
	}
	
	public String getDrinkName(int element){
		System.out.println("drinkName array length"+pizzaNames.length);
		return this.drinkNames[element];
	}
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
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
		return PizzaInOrder;
	}
	public void setPizzaInOrder(ArrayList<Pizza> pizzaInOrder) {
		PizzaInOrder = pizzaInOrder;
	}
	public ArrayList<Drink> getDrinkInOrder() {
		return DrinkInOrder;
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
	
	public String[] getPizzaNames() {
		return pizzaNames;
	}

	public String[] getDrinkNames() {
		return drinkNames;
	}

	public void setDrinkNames(String[] drinkNames) {
		this.drinkNames = drinkNames;
	}

	public void setPizzaNames(String[] pizzaNames) {
		this.pizzaNames = pizzaNames;
	}
}
