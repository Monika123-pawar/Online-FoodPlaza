package com.Foodplaza.dao;


public interface LoginDao {
	public boolean UserLogin(String username, String password);
	public boolean adminLogin(String username, String password);
}
