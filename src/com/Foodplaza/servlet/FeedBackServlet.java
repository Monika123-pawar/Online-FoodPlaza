package com.Foodplaza.servlet;

import java.io.IOException;
import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Foodplaza.dao.FeedBackDaoImp;
import com.Foodplaza.pojo.FeedBack;


@WebServlet("/FeedBackServlet")
public class FeedBackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    FeedBack f=new FeedBack();
    FeedBackDaoImp fee=new FeedBackDaoImp();
    public FeedBackServlet() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("hi");
		HttpSession session=request.getSession();
		String action=request.getParameter("action");
		//String customername=(String)session.getAttribute("customername");
		if(action!=null && action.equals("delete")) {
			System.out.println(action+"  data");
			int feedid=Integer.parseInt(request.getParameter("feedid"));
			boolean b=fee.DeleteData(feedid);
			if(b)
			{
				response.sendRedirect("FeedBackServlet");
			}
			else
			{
				response.sendRedirect("error.java");
			}
		}
		else {

			List<FeedBack> feelist=fee.SelectAll();
			session.setAttribute("c1",feelist);
			response.sendRedirect("feedbacklist.jsp");

		}
			}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getParameter("action");
		String  feedback =request.getParameter("feedback");
		String name=request.getParameter("name");
		String cemail=request.getParameter("emailid");
		
		f.setFeedback(feedback);
		f.setName(name);
		f.setCemail(cemail);
		
		if(action!=null && action.equals("InsertFeedBack")) {
			boolean b=fee.InsertData(f);
			if(b)
			{
				response.sendRedirect("index.jsp");
				
			}
			else
			{
				response.sendRedirect("error.jsp");
			}
			}
	}

}
