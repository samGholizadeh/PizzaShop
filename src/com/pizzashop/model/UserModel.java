package com.pizzashop.model;

import java.sql.*;

public class UserModel {
	
	public static int registerUser(String email, String username, String password, String firstname, String lastname, String adress, int phonenumber){
		ConnectionPool cp = ConnectionPool.getInstance();
		Connection connection = cp.getConnection();
		PreparedStatement ps = null;
		String sql = "INSERT INTO user(email, username, password, firstname, lastname, adress, phonenumber) VALUES(?, ?, ?, ?, ?, ? ,?)";
		int generatedKey = 0;
		
		try{
			ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, email);
			ps.setString(2, username);
			ps.setString(3, password);
			ps.setString(4, firstname);
			ps.setString(5, lastname);
			ps.setString(6, adress);
			ps.setInt(7, phonenumber);
			ps.executeUpdate();
			ResultSet Keys = ps.getGeneratedKeys();
			Keys.next();
			generatedKey = Keys.getInt(1);
		} catch (SQLException sqle){
			sqle.printStackTrace();
		} finally {
			DBUtil.closePreparedStatement(ps);
			cp.freeConnection(connection);
		}
		return generatedKey;
	}
}
