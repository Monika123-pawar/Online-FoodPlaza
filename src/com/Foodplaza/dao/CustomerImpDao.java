package com.Foodplaza.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.Foodplaza.pojo.Customer;
import com.Foodplaza.util.FoodplazaConnection;

public class CustomerImpDao {
	Connection con=FoodplazaConnection.getConnection();
	
	public boolean InsertData(Customer c)
	{
		String sql="insert into customermonika_22015(cname,caddress,ccontact,cemail,cpassword) values(?,?,?,?,?)"; 
		try 
		{
			PreparedStatement ps=con.prepareStatement(sql);
			//ps.setInt(1, c.getCid());
			ps.setString(1, c.getCname());
			ps.setString(2, c.getCaddress());
			ps.setString(3,c.getCcontact());
			ps.setString(4,c.getCemail());
			ps.setString(5,c.getCpassword());
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
		return  false;
	}


	public boolean UpdateData(Customer c) {
		String sql="update customermonika_22015 set cname=?,caddress=?,ccontact=?,cemail=?,cpassword=? where cid=?";
		try
		{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, c.getCname());
			ps.setString(2, c.getCaddress());
			ps.setString(3,c.getCcontact());
			ps.setString(4,c.getCemail());
			ps.setString(5,c.getCpassword());
			ps.setInt(6, c.getCid());
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


	public boolean DeleteData(int cid) {
		String sql="delete from  customermonika_22015 where cid=?";
		try
		{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1,cid);
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


	public List<Customer> SelectAll() {
		List<Customer> l=new ArrayList<>();
		String sql="select * from customermonika_22015";
		try {
		PreparedStatement ps=con.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			Customer c=new Customer();
			c.setCid(rs.getInt("cid"));
			c.setCname(rs.getString("cname"));
			c.setCaddress(rs.getString("caddress"));
			c.setCcontact(rs.getString("ccontact"));
			c.setCemail(rs.getString("cemail"));
			c.setCpassword(rs.getString("cpassword"));
			l.add(c);
		}
		return l;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}


	public Customer SelectById(int cid) {
		String sql="select * from customermonika_22015 where cid=?";
		Customer c=new Customer();
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, cid);
			ResultSet rs=ps.executeQuery();
		while(rs.next())
			{
			c.setCid(rs.getInt("cid"));
			c.setCname(rs.getString("cname"));
			c.setCaddress(rs.getString("caddress"));
			c.setCcontact(rs.getString("ccontact"));
			c.setCemail(rs.getString("cemail"));
			c.setCpassword(rs.getString("cpassword"));
			}
		return c;
			}
			catch(Exception e)
			{
				e.printStackTrace();
				}
		return null;
	}
	
	public int checkEmail(String custEmail) {
		
		String sql="select cemail from customermonika_22015 where cemail=?";
	//	Customer c=new Customer();
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, custEmail);
			ResultSet rs=ps.executeQuery();
		while(rs.next())
			{
			return 1;
			}
		
			}
			catch(Exception e)
			{
				e.printStackTrace();
				}
		return 2;
	}
	
	
	public Customer SelectByName(String userName) {
		String sql="select * from customermonika_22015 where cemail=?";
		Customer c=new Customer();
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, userName);
			ResultSet rs=ps.executeQuery();
		while(rs.next())
			{
			c.setCid(rs.getInt("cid"));
			c.setCname(rs.getString("cname"));
			c.setCaddress(rs.getString("caddress"));
			c.setCcontact(rs.getString("ccontact"));
			c.setCemail(rs.getString("cemail"));
			c.setCpassword(rs.getString("cpassword"));
			}
		return c;
			}
			catch(Exception e)
			{
				e.printStackTrace();
				}
		return null;
	}
}


