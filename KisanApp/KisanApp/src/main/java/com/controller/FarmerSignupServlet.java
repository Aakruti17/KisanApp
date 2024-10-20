package com.controller;

import java.io.IOException;

import com.bean.FarmerSignupBean;
import com.dao.FarmerSignupDAO;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/FarmerSignupServlet")
public class FarmerSignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
    public FarmerSignupServlet() {
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		HttpSession session = request.getSession();
		
		String sname = request.getParameter("fname");
		long scontact = Long.parseLong(request.getParameter("fcontact"));
		String svillage = request.getParameter("fvillage");
		String suname = request.getParameter("funame");
		String spwd = request.getParameter("fpwd");
		
		
		FarmerSignupBean fsbean = new FarmerSignupBean();
		fsbean.setName(sname);
		fsbean.setContact(scontact);
		fsbean.setVillage(svillage);
		fsbean.setUname(suname);
		fsbean.setPwd(spwd);
		
		FarmerSignupDAO fsdao = new FarmerSignupDAO();
		String result = fsdao.insertRecord(fsbean);
		
		
		if(result.equals("success")) {
			
			RequestDispatcher rd = request.getRequestDispatcher("farmerlogin.jsp");
			rd.forward(request, response);
		}
		
		else {
			session.setAttribute("signupstatus", "fail");
			RequestDispatcher rd = request.getRequestDispatcher("farmersignup.jsp");
			rd.forward(request, response);
			
			
		}	
	}

}
