package com.pizzashop.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.pizzashop.business.Pizza;

public class PizzaModel {
	
	public static ArrayList<Pizza> getPizzas(){
		
		ConnectionPool cp = ConnectionPool.getInstance();
		Connection connection = cp.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Pizza> PizzaList = new ArrayList<Pizza>();
		String query = "SELECT * FROM pizzanames";
		
		try{
			ps = connection.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()){
				Pizza pizza = new Pizza();
				pizza = new Pizza();
				pizza.setId(rs.getInt(1));
				pizza.setPrice(rs.getDouble(3));
				pizza.setName(rs.getString(2));
				PizzaList.add(pizza);
			}
		} catch (SQLException sqle){
			sqle.printStackTrace();
		} finally {
			DBUtil.closePreparedStatement(ps);
			DBUtil.closeResultSet(rs);
			cp.freeConnection(connection);
		}
		return PizzaList;
	}
	
	public static void insertPizza(double price, String name){
		
		ConnectionPool cp = ConnectionPool.getInstance();
		Connection connection = cp.getConnection();
		PreparedStatement ps = null;
		String query = "INSERT INTO pizza(namn, price) VALUES(?, ?)";
		
		try{
			ps.setString(1, name);
			ps.setDouble(2, price);
			ps.execute();
		} catch (SQLException sqle){
			sqle.printStackTrace();
		} finally{
			DBUtil.closePreparedStatement(ps);
			cp.freeConnection(connection);
		}
		
	}
}
