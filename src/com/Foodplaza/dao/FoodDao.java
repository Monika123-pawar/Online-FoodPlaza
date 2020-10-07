package com.Foodplaza.dao;

import java.util.List;

import com.Foodplaza.pojo.Food;

public interface FoodDao {
		public boolean InsertData(Food f);
		public boolean UpdateData(Food f);
		public boolean DeleteData(int fid);
		public List<Food> SelectAll();
		public Food SelectById(int fid);
}
