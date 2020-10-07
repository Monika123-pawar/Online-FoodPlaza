package com.Foodplaza.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Foodplaza.dao.CartImpDao;
import com.Foodplaza.dao.FoodOrderImpDao;
import com.Foodplaza.pojo.Cart;
import com.Foodplaza.pojo.Food;


@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	FoodOrderImpDao fd=new FoodOrderImpDao();
	CartImpDao cd=new CartImpDao();
    public CartServlet() {
       super(); 
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		String customername=(String)session.getAttribute("customername");
		String action=request.getParameter("action");
		
		if(action!=null && action.equals("delete")) {
			System.out.println(action+"  data");
			
			int cartid=Integer.parseInt(request.getParameter("cartId"));
			boolean b=cd.DeleteByID(cartid);
			if(b)
			{
				response.sendRedirect("CartServlet");
			}
			else
			{
				response.sendRedirect("error.java");
			}
		}
		
		
		else if(action!=null&& action.equals("addToCart"))
		{
			int foodid=Integer.parseInt(request.getParameter("foodId"));
			boolean b=cd.addToCart(foodid,customername);
			if(b)
			{
				response.sendRedirect("index.jsp");
			}
		}else {
			
			List<Cart> cartList=cd.SelectAll(customername);
			session.setAttribute("c", cartList);
			response.sendRedirect("showCart.jsp");
		}
		
	}
	
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String custEmail=(String)session.getAttribute("customername");
		
		
		String qty[]=request.getParameterValues("qty");
		String price[]=request.getParameterValues("price");
		
		double totalBill=0;
		
		for(int i=0;i<price.length;i++) {
		totalBill=totalBill+Integer.parseInt(qty[i])*Double.parseDouble(price[i]);
		
		}
		boolean b=fd.foodOrder(custEmail, totalBill);
		if(b) {
			request.setAttribute("orderMgs", "Your Total Bill is : "+totalBill);
			RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		}
		
	}

}
