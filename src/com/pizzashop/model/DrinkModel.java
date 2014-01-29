package com.pizzashop.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.pizzashop.business.Drink;

public class DrinkModel {
	
	public static ArrayList<Drink> getDrinks(){
		ConnectionPool cp = ConnectionPool.getInstance();
		Connection connection = cp.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Drink> DrinkList = new ArrayList<Drink>();
		String query = "SELECT * FROM drink";
		
		try{
			ps = connection.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()){
				Drink drink = new Drink();
				drink.setId(rs.getInt(1));
				drink.setName(rs.getString(2));
				drink.setPrice(rs.getDouble(3));
				DrinkList.add(drink);
			}
		} catch(SQLException sqle){
			sqle.printStackTrace();
		} finally {
			DBUtil.closePreparedStatement(ps);
			DBUtil.closeResultSet(rs);
			cp.freeConnection(connection);
		}
		return DrinkList;
	}
}
