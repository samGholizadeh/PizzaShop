package com.pizzashop.model;

import java.sql.*;
import java.util.ArrayList;

import com.pizzashop.business.Drink;
import com.pizzashop.business.Order;
import com.pizzashop.business.Pizza;

public class OrderModel {
	
	public static int insertOrder(int userid, double totalPrice, ArrayList<Pizza> PizzaInOrder, ArrayList<Drink> DrinkInOrder){
		
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
			for(int i = 0;  i < PizzaInOrder.size(); i++){
				sql = "INSERT INTO pizza.pizza_in_order(orderid, pizzaid, pizzaName) VALUES(?, ?, ?)";
				ps = connection.prepareStatement(sql);
				ps.setInt(1, generatedPrimaryKey);
				ps.setInt(2, PizzaInOrder.get(i).getId());
				ps.setString(3, PizzaInOrder.get(i).getName());
				ps.executeUpdate();
				DBUtil.closePreparedStatement(ps);
			}
			for(int i = 0; i < DrinkInOrder.size(); i++){
				sql = "INSERT INTO pizza.drink_in_order(orderid, drinkid, drinkName) VALUES(?, ?, ?)";
				ps = connection.prepareStatement(sql);
				ps.setInt(1, generatedPrimaryKey);
				ps.setInt(2, DrinkInOrder.get(i).getId());
				ps.setString(3, DrinkInOrder.get(i).getName());
				ps.executeUpdate();
			}
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
		String sql = "SELECT pizza.order.*, pizza.user.* FROM pizza.order LEFT JOIN pizza.user ON pizza.order.userid = pizza.user.userid";
		Order order = null;
		ArrayList<Order> OrderList = new ArrayList<Order>();
		//Skulle kunna använda INNER join men det skapar redundency i ResultSet och därför kör jag två queries till och lägger till det resultset i Order
		//objektet.
		try{
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				order = new Order();
				order.setId(rs.getInt(1));
				order.setUserId(rs.getInt(2));
				order.setTimestamp(rs.getString(3));
				order.setStatus(rs.getInt(4));
				order.setTotalPrice(rs.getDouble("price"));
				order.setFirstname(rs.getString("firstname"));
				order.setLastname(rs.getString("lastname"));
				order.setAddress(rs.getString("adress"));
				sql = "SELECT * FROM pizza_in_order WHERE orderid = ?";
				ps = connection.prepareStatement(sql);
				ps.setInt(1, rs.getInt(1));
				orderSpec = ps.executeQuery();
				for(int i = 0; orderSpec.next(); i++){
					Pizza Pizza = new Pizza();
					Pizza.setName(orderSpec.getString("pizzaName"));
					order.getPizzaInOrder().add(Pizza);
				}
				DBUtil.closePreparedStatement(ps);
				DBUtil.closeResultSet(orderSpec);
				sql = "SELECT * FROM drink_in_order WHERE orderid = ?";
				ps = connection.prepareStatement(sql);
				ps.setInt(1, rs.getInt(1));
				orderSpec = ps.executeQuery();
				while(orderSpec.next()){
					Drink Drink = new Drink();
					Drink.setName(orderSpec.getString("drinkName"));
					order.getDrinkInOrder().add(Drink);
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
		String sql = "SELECT * FROM pizza.order WHERE pizza.order.userid = ?";
		Order order = null;
		ArrayList<Order> OrderList = new ArrayList<Order>();
		//Skulle kunna använda INNER join men det skapar redundency i ResultSet och därför kör jag två queries till och lägger till det resultset i Order
		//objektet.
		try{
			ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, userid);
			rs = ps.executeQuery();
			while(rs.next()){
				order = new Order();
				order.setId(rs.getInt(1));
				order.setUserId(rs.getInt(2));
				order.setTimestamp(rs.getString(3));
				order.setStatus(rs.getInt(4));
				order.setTotalPrice(rs.getDouble("price"));
				sql = "SELECT * FROM pizza.pizza_in_order WHERE pizza.pizza_in_order.orderid = ?";
				ps = connection.prepareStatement(sql);
				ps.setInt(1, rs.getInt(1));
				orderSpec = ps.executeQuery();
				while(orderSpec.next()){
					Pizza Pizza = new Pizza();
					Pizza.setName(orderSpec.getString("pizzaName"));
					order.getPizzaInOrder().add(Pizza);
				}
				DBUtil.closePreparedStatement(ps);
				DBUtil.closeResultSet(orderSpec);
				sql = "SELECT * FROM drink_in_order WHERE orderid = ?";
				ps = connection.prepareStatement(sql);
				ps.setInt(1, rs.getInt(1));
				orderSpec = ps.executeQuery();
				while(orderSpec.next()){
					Drink Drink = new Drink();
					Drink.setName(orderSpec.getString("drinkName"));
					order.getDrinkInOrder().add(Drink);
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
	
	public static void removeOrder(int orderId){
		ConnectionPool cp = ConnectionPool.getInstance();
		Connection connection = cp.getConnection();
		PreparedStatement ps = null;
		String sql = "DELETE FROM pizza.order WHERE pizza.order.orderid = ?";
		try{
			ps = connection.prepareStatement(sql);
			ps.setInt(1, orderId);
			ps.executeUpdate();
		} catch (SQLException e){
			e.printStackTrace();
		} finally {
			DBUtil.closePreparedStatement(ps);
			cp.freeConnection(connection);
		}
	}
	
	public static void changeOrderStatus(int orderId){
		ConnectionPool cp = ConnectionPool.getInstance();
		Connection connection = cp.getConnection();
		PreparedStatement ps = null;
		String sql = "UPDATE pizza.order SET pizza.order.status = 1 WHERE pizza.order.orderid = ?";
		
		try{
			ps = connection.prepareStatement(sql);
			ps.setInt(1, orderId);
			ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		} finally{
			DBUtil.closePreparedStatement(ps);
			cp.freeConnection(connection);
		}
	}
	
	public static int searchMethod(String pizzaName, int userId){
		ConnectionPool cp = ConnectionPool.getInstance();
		Connection connection = cp.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT COUNT(pizza.pizza_in_order.pizzaName) FROM pizza.pizza_in_order RIGHT JOIN pizza.order ON pizza.pizza_in_order.orderid = pizza.order.orderid WHERE pizza.order.userid = ? AND pizza.pizza_in_order.pizzaName = ?";
		int holder = 0;
		try{
			Statement st = connection.createStatement();
			st.execute("USE pizza");
			ps = connection.prepareStatement(sql);
			ps.setInt(1, userId);
			ps.setString(2, pizzaName);
			rs = ps.executeQuery();
			rs.next();
			holder = rs.getInt(1);
		} catch(SQLException e){
			e.printStackTrace();
		} finally{
			DBUtil.closePreparedStatement(ps);
			DBUtil.closeResultSet(rs);
		}
		
		return holder;
	}	
}
