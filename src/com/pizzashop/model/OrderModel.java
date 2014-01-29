package com.pizzashop.model;

import java.awt.image.DataBuffer;
import java.sql.*;
import java.util.ArrayList;

import com.pizzashop.business.Order;
import com.pizzashop.business.Pizza;

public class OrderModel {
	
	public static int insertOrder(int userid, double totalPrice, int pizzaId, int drinkid){
		
		ConnectionPool cp = ConnectionPool.getInstance();
		Connection connection = cp.getConnection();
		PreparedStatement ps = null;
		String sql = "INSERT INTO pizza.order(userid, status, price) VALUES(?, ?, ?)";
		int generatedPrimaryKey = 0;
		
		try{
			ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, userid);
			ps.setInt(2, 0);
			ps.setDouble(3, totalPrice);
			ps.executeUpdate();
			ResultSet GeneratedKeys = ps.getGeneratedKeys();
			GeneratedKeys.next();
			generatedPrimaryKey = GeneratedKeys.getInt(1);
			DBUtil.closePreparedStatement(ps);
			sql = "INSERT INTO pizza.pizza_in_order(orderid, pizzaid) VALUES(?, ?)";
			ps = connection.prepareStatement(sql);
			ps.setInt(1, generatedPrimaryKey);
			ps.setInt(2, pizzaId);
			ps.executeUpdate();
			DBUtil.closePreparedStatement(ps);
			sql = "INSERT INTO pizza.drink_in_order(orderid, drinkid) VALUES(?, ?)";
			ps = connection.prepareStatement(sql);
			ps.setInt(1, generatedPrimaryKey);
			ps.setInt(2, drinkid);
			ps.executeUpdate();
		} catch(SQLException sqle){
			sqle.printStackTrace();
		} finally {
			DBUtil.closePreparedStatement(ps);
			cp.freeConnection(connection);
		}
		
		return generatedPrimaryKey;
	}
	
	public static ArrayList<Order> getOrders(){
		ConnectionPool cp = ConnectionPool.getInstance();
		Connection connection = cp.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		ResultSet orderSpec = null;
		String sql = "SELECT * FROM order";
		Order order = null;
		ArrayList<Order> OrderList = new ArrayList<Order>();
		//Skulle kunna anv�nda INNER join men det skapar redundency i ResultSet och d�rf�r k�r jag tv� queries till och l�gger till det resultset i Order
		//objektet.
		try{
			ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			rs = ps.executeQuery();
			while(rs.next()){
				order = new Order();
				order.setOrderId(rs.getInt(1));
				order.setUserId(rs.getInt(2));
				order.setTimestamp(rs.getString(3));
				order.setStatus(rs.getInt(4));
				order.setTotalPrice(rs.getDouble("price"));
				sql = "SELECT * FROM pizza_in_order WERE orderid = ?";
				ps = connection.prepareStatement(sql);
				ps.setInt(1, rs.getInt(1));
				orderSpec = ps.executeQuery();
				int itemCount = 0;
				if(orderSpec.last()){
					itemCount = orderSpec.getRow();
					orderSpec.beforeFirst();
				}
				order.initializePizzaNames(itemCount);
				for(int i = 0; orderSpec.next(); i++){
					order.setPizzaName(i, orderSpec.getString("pizzaName"));
				}
				itemCount = 0;
				DBUtil.closePreparedStatement(ps);
				DBUtil.closeResultSet(orderSpec);
				sql = "SELECT * FROM drink_in_order WHERE orderid = ?";
				ps = connection.prepareStatement(sql);
				orderSpec = ps.executeQuery();
				if(orderSpec.last()){
					itemCount = orderSpec.getRow();
					orderSpec.beforeFirst();
				}
				order.initializeDrinkNames(itemCount);
				for(int i = 0; orderSpec.next(); i++){
					order.setDrinkName(i, orderSpec.getString("drinkName"));
				}
				OrderList.add(order);
			}
		} catch (SQLException sqle){
			sqle.printStackTrace();
		} finally{
			DBUtil.closePreparedStatement(ps);
			DBUtil.closeResultSet(rs);
			cp.freeConnection(connection);
		}
		return OrderList;
	}
	
	public static ArrayList<Order> getOrders(int userid){
		ConnectionPool cp = ConnectionPool.getInstance();
		Connection connection = cp.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		ResultSet orderSpec = null;
		String sql = "SELECT * FROM order WHERE userid = ?";
		Order order = null;
		ArrayList<Order> OrderList = new ArrayList<Order>();
		//Skulle kunna anv�nda INNER join men det skapar redundency i ResultSet och d�rf�r k�r jag tv� queries till och l�gger till det resultset i Order
		//objektet.
		try{
			ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, userid);
			rs = ps.executeQuery();
			while(rs.next()){
				order = new Order();
				order.setOrderId(rs.getInt(1));
				order.setUserId(rs.getInt(2));
				order.setTimestamp(rs.getString(3));
				order.setStatus(rs.getInt(4));
				order.setTotalPrice(rs.getDouble("price"));
				sql = "SELECT * FROM pizza_in_order WERE orderid = ?";
				ps = connection.prepareStatement(sql);
				ps.setInt(1, rs.getInt(1));
				orderSpec = ps.executeQuery();
				int itemCount = 0;
				if(orderSpec.last()){
					itemCount = orderSpec.getRow();
					orderSpec.beforeFirst();
				}
				order.initializePizzaNames(itemCount);
				for(int i = 0; orderSpec.next(); i++){
					order.setPizzaName(i, orderSpec.getString("pizzaName"));
				}
				itemCount = 0;
				DBUtil.closePreparedStatement(ps);
				DBUtil.closeResultSet(orderSpec);
				sql = "SELECT * FROM drink_in_order WHERE orderid = ?";
				ps = connection.prepareStatement(sql);
				orderSpec = ps.executeQuery();
				if(orderSpec.last()){
					itemCount = orderSpec.getRow();
					orderSpec.beforeFirst();
				}
				order.initializeDrinkNames(itemCount);
				for(int i = 0; orderSpec.next(); i++){
					order.setDrinkName(i, orderSpec.getString("drinkName"));
				}
				OrderList.add(order);
			}
		} catch (SQLException sqle){
			sqle.printStackTrace();
		} finally{
			DBUtil.closePreparedStatement(ps);
			DBUtil.closeResultSet(rs);
			cp.freeConnection(connection);
		}
		return OrderList;
	}
}
