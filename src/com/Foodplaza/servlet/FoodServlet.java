package com.Foodplaza.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Foodplaza.dao.FoodDao;
import com.Foodplaza.dao.FoodImpDao;
import com.Foodplaza.pojo.Food;


@WebServlet("/FoodServlet")
public class FoodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 Food f=new Food();
 FoodImpDao fd=new FoodImpDao();
    public FoodServlet() {
    	
        super();
    }

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("hi");
		HttpSession session=request.getSession();
		String action=request.getParameter("action");
		
		if(action!=null && action.equals("delete")) {
			System.out.println(action+"  data");
			int fid=Integer.parseInt(request.getParameter("foodId"));
			boolean b=fd.DeleteData(fid);
			if(b)
			{
				response.sendRedirect("FoodServlet");
			}
			else
			{
				response.sendRedirect("error.java");
			}
		}
		
		else if(action!=null && action.equals("edit")) {
			int fid=Integer.parseInt(request.getParameter("foodId"));
			Food f=fd.SelectById(fid);
			session.setAttribute("selectbyId", f);
			response.sendRedirect("updatefood.jsp");
		}
		
		else {
		List<Food> flist=fd.SelectAll();
		session.setAttribute("f1",flist);
		response.sendRedirect("foodlist.jsp");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("hello");
		String action=request.getParameter("action");
		String food_name=request.getParameter("food_name");
		Double food_price=Double.parseDouble(request.getParameter("food_price"));
		String food_category=request.getParameter("food_category");
		System.out.println("food name "+food_name+" food price "+food_price+" food category "+food_category);
		
		f.setFname(food_name);
		f.setFprice(food_price);
		f.setFcategory(food_category);
		if(action!=null && action.equals("addfood")) {
		boolean b=fd.InsertData(f);
		
		if(b)
		{
			response.sendRedirect("FoodServlet");
		}
		else
		{
			response.sendRedirect("error.jsp");
		}
		}
		else if(action!=null && action.equals("updateFood"))
		{
			int fid=Integer.parseInt(request.getParameter("foodId"));
			f.setFid(fid);
			boolean b=fd.UpdateData(f);
			if(b)
			{
				response.sendRedirect("FoodServlet");
			}
			else
			{
				response.sendRedirect("error.jsp");
			}
		}
	}

	

}
