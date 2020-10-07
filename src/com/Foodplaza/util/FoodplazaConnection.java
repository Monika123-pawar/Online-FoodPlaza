package com.Foodplaza.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class FoodplazaConnection {
	private  final static String driver ="com.mysql.jdbc.Driver";
	private final static String url="jdbc:mysql://localhost:3306/foodplazamonika_22015";
	private final static String username="root";
	private final static String password="root";

	public static Connection getConnection()
	{
		Connection con=null;
		try
		{
			Class.forName(driver);
			con=DriverManager.getConnection(url,username,password);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return con;
}
}
