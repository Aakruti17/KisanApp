package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import com.bean.AdminSignupBean;
import com.dao.AdminSignupDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminSignupServlet
 */
@WebServlet("/AdminSignupServlet")
public class AdminSignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


    public AdminSignupServlet() {
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter pw = response.getWriter();
		
		//read input comming from HTML Form submission
		String sname = request.getParameter("aname");
		String semail = request.getParameter("aemail");
		int scontact = Integer.parseInt(request.getParameter("acontact"));//"112233" - 112233
		String saddress = request.getParameter("address");
		
		
		AdminSignupBean asbean = new AdminSignupBean();
		asbean.setName(sname); //it will transfer a copy of servlet variable sname value into bean priravate variables name
		asbean.setAddress(saddress);
		asbean.setContact(scontact);
		asbean.setEmail(semail);
		
		//we have created object of AdminSignupDAO class
		AdminSignupDAO asdao = new AdminSignupDAO();
		String result = asdao.insertData(asbean);
		
		//process the result
		if(result.equals("success")) {
			
			pw.println("<HTML><BODY bgcolor='green'>");
			pw.println("<H3>Admin Signup Success!!!!!!!!!!!!!!!!</H3>");
			pw.println("</HTML></BODY>");
		}
		else {
			
			pw.println("<HTML><BODY bgcolor='red'>");
			pw.println("<H3>Admin Signup Fail...............</H3>");
			pw.println("</HTML></BODY>");
		}
		
		
		
		
		
		
		
		
	}

}
