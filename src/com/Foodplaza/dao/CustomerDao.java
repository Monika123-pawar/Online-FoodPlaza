package com.Foodplaza.dao;

import java.util.List;

import com.Foodplaza.pojo.Customer;

public interface CustomerDao {
		public boolean InsertData(Customer c);
		public boolean UpdateData(Customer c);
		public boolean DeleteData(int cid);
		public List<Customer> SelectAll();
		public Customer SelectById(int cid);
}
