package com.Foodplaza.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.Foodplaza.pojo.Cart;
import com.Foodplaza.pojo.FoodOrder;
import com.Foodplaza.util.FoodplazaConnection;

public class FoodOrderImpDao implements FoodOrderDao{

	Connection con=FoodplazaConnection.getConnection();
	
	
	public boolean placeOrder(String custEmail) {
		double totalbill=0;
		String sql=" select sum(fprice*qty) as totalbill from foodmonika_22015 inner join cartmonika_22015 on cartmonika_22015.fid=foodmonika_22015.fid where cemail=?";
	try {
		
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, custEmail);
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			totalbill=rs.getDouble("totalBill");
		
		}
		
		String orderDate=new Date().toString();
		String status="proccessing";
		
				
		String sql1="insert into foodordermonika_22015 (totalbill,cemail,orderdate,status) values(?,?,?,?)";
		
		PreparedStatement ps1=con.prepareStatement(sql1);
		ps1.setString(2, custEmail);
		ps1.setDouble(1, totalbill);
		ps1.setString(3, orderDate);
		ps1.setString(4, status);
		
		int i=ps1.executeUpdate();
		if(i>0) {
		return true;
		}
				
	}
	catch (Exception e) 
	{
	e.printStackTrace();
	}
	return false;
	}
	
	
	
	
	public boolean foodOrder(String custEmail,double totalBill) {
		
		String orderDate=new Date().toString();
		String status="proccessing";
		
		 
	try {
		String sql="insert into foodordermonika_22015(totalbill,cemail,orderdate,status) values(?,?,?,?)";
			
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(2, custEmail);
		ps.setDouble(1, totalBill);
		ps.setString(3, orderDate);
		ps.setString(4, status);
		
		int i=ps.executeUpdate();
		if(i>0) {
			return true;
		}
	}
	catch (Exception e) 
	{
	e.printStackTrace();
	}
	return false;
	}
	
	
	
//	public static void main(String[] args) {
//		System.out.println(new FoodOrderImpDao().placeOrder("sona123@gmail.com"));
//	}
	
	
	
	
		
	public boolean DeleteByID(int orderid) {
		String sql="delete from  foodordermonika_22015 where orderid=?";
		try
		{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1,orderid);
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
	
	public List<FoodOrder> SelectAll() {
		List<FoodOrder> l=new ArrayList<>();
		String sql="select * from foodordermonika_22015 ";
		try {
		PreparedStatement ps=con.prepareStatement(sql);
	
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			FoodOrder fo=new FoodOrder();
			fo.setOrderid(rs.getInt("orderid"));
			fo.setTotalbill(rs.getDouble("totalBill"));
			fo.setCemail(rs.getString("cemail"));
			fo.setOrderdate(rs.getString("orderdate"));
			fo.setStatus(rs.getString("status"));
			l.add(fo);
		}
		return l;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
}
