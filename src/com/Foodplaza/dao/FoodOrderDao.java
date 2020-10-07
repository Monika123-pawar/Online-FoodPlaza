package com.Foodplaza.dao;

import java.util.List;

import com.Foodplaza.pojo.FoodOrder;

public interface FoodOrderDao {
	public boolean placeOrder(String cemail);
	public boolean DeleteByID(int orderid);
	public List<FoodOrder>SelectAll();

}