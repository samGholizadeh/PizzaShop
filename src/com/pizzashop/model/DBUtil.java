package com.pizzashop.model;

import java.sql.*;

public class DBUtil {
	
	public static void closeStatement(Statement s)
	{
		try
		{
			if (s != null)
				s.close();
		}
		catch (SQLException sqle)
		{
			sqle.printStackTrace();
		}
	}
	
	public static void closePreparedStatement(PreparedStatement ps)
	{
		try
		{
			if(ps != null)
				ps.close();
		}
		catch(SQLException sqle)
		{
			sqle.printStackTrace();
		}
	}
	
	public static void closeResultSet(ResultSet rs)
	{
		try
		{
			if (rs != null)
				rs.close();
		}
		catch (SQLException sqle)
		{
			sqle.printStackTrace();
		}
	}

}
