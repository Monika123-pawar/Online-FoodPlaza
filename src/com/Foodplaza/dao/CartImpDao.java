package com.Foodplaza.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.Foodplaza.pojo.Cart;
import com.Foodplaza.util.FoodplazaConnection;

public class CartImpDao  implements CartDao{
	Connection con=FoodplazaConnection.getConnection();
	
	public boolean AddCart(Cart crt) {
String sql="insert into cartmonika_22015(fid,cemail,qty)  values(?,?,?)";
try
{

	PreparedStatement ps=con.prepareStatement(sql);
	//ps.setInt(1, crt.getCartid());
	ps.setInt(1, crt.getFid());
	ps.setString(2,crt.getCemail());
	ps.setInt(3, crt.getQty());
	int i=ps.executeUpdate();
	if(i>0)
	{
		return true;
	}
}
catch(Exception e)
{
	System.out.println(e.getMessage());
}
		return false;
	}
	
	
	public boolean DeleteByID(int cartid) {
		String sql="delete from  cartmonika_22015 where cartid=?";
		try
		{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1,cartid);
			int i=ps.executeUpdate();
			if(i>0)
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


	public List<Cart> SelectAll(String cemail) {
		List<Cart> l=new ArrayList<>();
		String sql="select cartid,fname,fprice from cartmonika_22015 crt inner join foodmonika_22015 f on crt.fid=f.fid  where crt.cemail=?";
		try {
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, cemail);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			Cart crt=new Cart();
			crt.setCartid(rs.getInt("cartid"));
			crt.setFname(rs.getString("fname"));
			crt.setFprice(rs.getDouble("fprice"));
			
			l.add(crt);
		}
		return l;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	public boolean addToCart(int foodid,String customername)
	{
		String sql="insert into cartmonika_22015(fid,cemail)  values(?,?)";
		try
		{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1,foodid);
			ps.setString(2,customername);
			int i=ps.executeUpdate();
			if(i>0)
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
