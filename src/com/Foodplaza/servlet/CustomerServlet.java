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

import com.Foodplaza.dao.CustomerImpDao;
import com.Foodplaza.pojo.Customer;
import com.Foodplaza.pojo.Food;
//import com.sun.swing.internal.plaf.basic.resources.basic;


@WebServlet("/CustomerServlet")
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Customer c=new Customer();
	CustomerImpDao cd=new CustomerImpDao();
	public CustomerServlet() {
		super();

	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("hi");
		HttpSession session=request.getSession();
		String action=request.getParameter("action");
		String customername=(String)session.getAttribute("customername");
		if(action!=null && action.equals("delete")) {
			System.out.println(action+"  data");
			int customerId=Integer.parseInt(request.getParameter("customerId"));
			boolean b=cd.DeleteData(customerId);
			if(b)
			{
				response.sendRedirect("CustomerServlet");
			}
			else
			{
				response.sendRedirect("error.java");
			}
		}
		else if(action!=null && action.equals("edit")) {

			int cid=Integer.parseInt(request.getParameter("customerId"));
			System.out.println("GGGGG "+cid);
			Customer c=cd.SelectById(cid);
			session.setAttribute("selectBy", c);
			response.sendRedirect("updatecustomer.jsp");
		}
		else if(action!=null &&action.equals("editProfile")) {
			
			Customer c=cd.SelectByName(customername);
			session.setAttribute("selectBy", c);
			response.sendRedirect("updatecustomer.jsp");
		}
		else {

			List<Customer> clist=cd.SelectAll();
			session.setAttribute("c1",clist);
			response.sendRedirect("customerlist.jsp");

		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("hello");

		
		String action=request.getParameter("action");

		String cname=request.getParameter("customer_name");
		String caddress=request.getParameter("customer_address");
		String ccontact=request.getParameter("customer_contact");
		String cemail=request.getParameter("customer_email");
		String cpassword=request.getParameter("customer_password");
		System.out.println("Customer name "+cname+" customer_address "+caddress+" customer_contact "+ccontact+" customer_email "+cemail+" customer_password "+cpassword);
		c.setCname(cname);
		c.setCaddress(caddress);
		c.setCcontact(ccontact);
		c.setCemail(cemail);
		c.setCpassword(cpassword);
		if(action!=null && action.equals("addCust")) {
			int i=cd.checkEmail(cemail);
			if(i==1) {
				
				request.setAttribute("checkEmail", "Email Id is Already Exist");
				RequestDispatcher rd=request.getRequestDispatcher("customer.jsp");
				rd.forward(request, response);
			}
			else {
			boolean b=cd.InsertData(c);
			if(b)
			{
				response.sendRedirect("CustomerServlet");
				
			}
			else
			{
				response.sendRedirect("error.jsp");
			}
			}
		}
		
		else if(action!=null && action.equals("updateCust")) {
			
			int cid=Integer.parseInt(request.getParameter("cid"));
			c.setCid(cid);
			
			boolean b=cd.UpdateData(c);
			if(b) {
				request.setAttribute("msg", "Updated Successfully");
				RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
			}else {
				response.sendRedirect("error.jsp");
			}
		}
	}


}
