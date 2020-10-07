package com.Foodplaza.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.Foodplaza.util.FoodplazaConnection;


public class LoginDaoImp implements LoginDao{
	
	Connection con=FoodplazaConnection.getConnection();
	public boolean UserLogin(String username, String password) {
		String sql="select cemail,cpassword from customermonika_22015 where cemail=? and cpassword=?";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				return true;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}

	
	public boolean adminLogin(String username, String password) {
		String sql="select username,password from loginmonika_22015 where username=? and password=?";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				return true;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}
	

}
