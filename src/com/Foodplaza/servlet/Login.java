package com.Foodplaza.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Foodplaza.dao.LoginDaoImp;


@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   LoginDaoImp ld=new LoginDaoImp();
    public Login() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		session.invalidate();
		response.sendRedirect("index.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		System.out.println("hii");
		String select=request.getParameter("select");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		System.out.println(select+" "+username+" "+password);
		if(select!=null && select.equals("customer"))
		{
			boolean b=ld.UserLogin(username,password);
			if(b)
			{
				session.setAttribute("customername", username);
				response.sendRedirect("index.jsp");
			}
			else
			{
				response.sendRedirect("error.jsp");
			}
		}
		else if(select!=null && select.equals("admin"))
		{
			
			boolean b=ld.adminLogin(username, password);
			if(b)
			{
				session.setAttribute("adminname", username);
				response.sendRedirect("index.jsp");
			}
			else
			{
				response.sendRedirect("error.jsp");
			}
				
		}
	}

}
