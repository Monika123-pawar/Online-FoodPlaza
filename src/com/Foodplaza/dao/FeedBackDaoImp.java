
package com.Foodplaza.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.Foodplaza.pojo.FeedBack;
import com.Foodplaza.util.FoodplazaConnection;

public class FeedBackDaoImp implements FeedBackDao {
	Connection con=FoodplazaConnection.getConnection();
	@Override
	public boolean InsertData(FeedBack f) {
		String sql="insert into feedbackmonika_22015(feedback,name,cemail) values(?,?,?)"; 
		try 
		{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, f.getFeedback());
			ps.setString(2, f.getName());
			ps.setString(3,f.getCemail());
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

	@Override
	public boolean DeleteData(int feedid) {
		String sql="delete from  feedbackmonika_22015 where feedid=?";
		try
		{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1,feedid);
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

	@Override
	public List<FeedBack> SelectAll() {
		List<FeedBack> l=new ArrayList<>();
		String sql="select * from feedbackmonika_22015";
		try {
		PreparedStatement ps=con.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			FeedBack f=new FeedBack();
			f.setFeedid(rs.getInt("feedid"));
			f.setName(rs.getString("name"));
			f.setCemail(rs.getString("cemail"));
			f.setFeedback(rs.getString("feedback"));
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

}
