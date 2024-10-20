package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import com.bean.AdminLoginBean;
import com.dao.AdminLoginDAO;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

   
    public AdminLoginServlet() {
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter pw = response.getWriter();
		
		HttpSession session = request.getSession();
		
		//read input values/data comming from HTML Login Form Submission
		String semail = request.getParameter("aemail");
		int scontact = Integer.parseInt(request.getParameter("acontact"));
		
		//transfer servlet variables data copy to bean private variables 
		AdminLoginBean albean = new AdminLoginBean();
		albean.setEmail(semail);
		albean.setContact(scontact);
		
		//call verifyLoginCredential() method of AdminLoginDAO class
		AdminLoginDAO aldao = new AdminLoginDAO();
		String result = aldao.verifyLoginCredentials(albean);
		
		//process the result
		if(result.equals("success")) {
			
			RequestDispatcher rd = request.getRequestDispatcher("admin_dashboard1.html");
			rd.forward(request, response);
			
		}
		else {
			
			session.setAttribute("loginstatus", "fail");
			RequestDispatcher rd = request.getRequestDispatcher("admin_login1.jsp");
			rd.forward(request, response);
		}
		
		
		
		
		
		
		
		
	}

}
