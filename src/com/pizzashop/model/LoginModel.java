package com.pizzashop.model;

import java.sql.Connection;
import java.sql.*;
import java.util.*;
import com.pizzashop.business.User;

public class LoginModel {
	
	public static User login(String id, String pw){
		
		ConnectionPool cp = ConnectionPool.getInstance();
		Connection connection = cp.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		User user = null;
		String query = "SELECT * FROM user WHERE username = ?";
		
		try{
			ps = connection.prepareStatement(query);
			ps.setString(1, id);
			rs = ps.executeQuery();
			while(rs.next()){
				System.out.println(rs.getInt(1));
				user = new User();
				user.setId(rs.getInt(1));
				user.setEmail(rs.getString(2));
				user.setUsername(rs.getString(3));
				user.setPassword(rs.getString(4));
				user.setFirstname(rs.getString(5));
				user.setLastname(rs.getString(6));
				user.setAdress(rs.getString(7));
				user.setPhonenumber(rs.getInt(8));
			}
		}
		catch(SQLException sqle)
		{
			sqle.printStackTrace();
		}
		finally
		{
			DBUtil.closePreparedStatement(ps);
			DBUtil.closeResultSet(rs);
			cp.freeConnection(connection);
		//email, username, password, firstname, lastname, adress, phonenumber
		}
		return user;
	}
}