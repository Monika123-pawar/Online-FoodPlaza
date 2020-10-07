package com.Foodplaza.dao;

import java.util.List;

import com.Foodplaza.pojo.Cart;

public interface CartDao {
public boolean AddCart(Cart crt);
public boolean DeleteByID(int cartid);
public List<Cart>SelectAll(String cemail);
}
