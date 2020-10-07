package com.Foodplaza.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Foodplaza.dao.FoodOrderImpDao;
import com.Foodplaza.pojo.Cart;
import com.Foodplaza.pojo.FoodOrder;


@WebServlet("/FoodOrderServlet")
public class FoodOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	FoodOrderImpDao fod=new FoodOrderImpDao();
    public FoodOrderServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	System.out.println("123");
		HttpSession session=request.getSession();
		String customername=(String)session.getAttribute("customername");
		String action=request.getParameter("action");
		
		if(action!=null && action.equals("delete")) {
			System.out.println(action+"  data");
			
			int orderid=Integer.parseInt(request.getParameter("orderId"));
			boolean b=fod.DeleteByID(orderid);
			if(b)
			{
				response.sendRedirect("FoodOrderServlet");
			}
			else
			{
				response.sendRedirect("error.java");
			}
		}
else {
			
			List<FoodOrder> foodOrderlist=fod.SelectAll();
			session.setAttribute("f1", foodOrderlist);
			response.sendRedirect("FoodOrderList.jsp");
		}
		
		
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("hi3");
	}

}
