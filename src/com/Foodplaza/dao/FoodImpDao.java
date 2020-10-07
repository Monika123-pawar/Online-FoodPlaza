package com.Foodplaza.dao;
import java.util.Scanner;

import com.Foodplaza.pojo.Food;
import com.Foodplaza.util.FoodplazaConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class FoodImpDao implements FoodDao{
	
	Connection con=FoodplazaConnection.getConnection();
	
public boolean InsertData(Food f)
{
	String sql="insert into foodmonika_22015(fname,fprice,fcategory) values(?,?,?)"; 
	try 
	{
		PreparedStatement ps=con.prepareStatement(sql);
		//ps.setInt(1, f.getFid());
		ps.setString(1, f.getFname());
		ps.setDouble(2, f.getFprice());
		ps.setString(3,f.getFcategory());
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


public boolean UpdateData(Food f) {
	String sql="update foodmonika_22015 set fname=?,fprice=?,fcategory=? where fid=?";
	try
	{
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1,f.getFname());
		ps.setDouble(2,f.getFprice());
		ps.setString(3,f.getFcategory());
		ps.setInt(4,f.getFid());
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


public boolean DeleteData(int fid) {
	String sql="delete from  foodmonika_22015 where fid=?";
	try
	{
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setInt(1,fid);
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


public List<Food> SelectAll() {
	List<Food> l=new ArrayList<>();
	String sql="select * from foodmonika_22015";
	try {
	PreparedStatement ps=con.prepareStatement(sql);
	ResultSet rs=ps.executeQuery();
	while(rs.next())
	{
		Food f=new Food();
		f.setFid(rs.getInt("fid"));
		f.setFname(rs.getString("fname"));
		f.setFprice(rs.getDouble("fprice"));
		f.setFcategory(rs.getString("fcategory"));
		l.add(f);
	}
	return l;
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return null;
}


public Food SelectById(int fid) {
	String sql="select * from foodmonika_22015 where fid=?";
	Food f=new Food();
	try {
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setInt(1, fid);
		ResultSet rs=ps.executeQuery();
	while(rs.next())
		{
		f.setFid(rs.getInt("fid"));
		f.setFname(rs.getString("fname"));
		f.setFprice(rs.getDouble("fprice"));
		f.setFcategory(rs.getString("fcategory"));
		}
	return f;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			}
	return null;
}
//public static void main(String []args)
//{
//	Scanner sc=new Scanner(System.in);
//	Food f=new Food();
//	FoodImpDao f1=new FoodImpDao();
//	System.out.println("Enter fid ,fname,fprice fcategory for insert");
//	int fid=sc.nextInt();
//	String fname=sc.next();
//	Double fprice=sc.nextDouble();
//	String fcategory=sc.next();
//	f.setFid(fid);
//	f.setFname(fname);
//	f.setFprice(fprice);
//	f.setFcategory(fcategory);
//	f1.InsertData(f);
//}
}
