package com.Foodplaza.dao;

import java.util.List;

import com.Foodplaza.pojo.FeedBack;

public interface FeedBackDao {
	public boolean InsertData(FeedBack f);
	public boolean DeleteData(int feedid);
	public List<FeedBack> SelectAll() ;
}
