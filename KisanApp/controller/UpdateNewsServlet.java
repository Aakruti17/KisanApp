package com.controller;

import java.io.IOException;

import com.bean.UpdateNewsBean;
import com.dao.UpdateNewsDAO;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/UpdateNewsServlet")
public class UpdateNewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
    public UpdateNewsServlet() {
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		String sncontents = request.getParameter("ncontents");
		String sndate = request.getParameter("ndate");
		String sntype = request.getParameter("ntype");
		
		UpdateNewsBean unbean = new UpdateNewsBean();
		unbean.setNcontents(sncontents);
		unbean.setDate(sndate);
		unbean.setNtype(sntype);
		
		UpdateNewsDAO undao = new UpdateNewsDAO();
		String result = undao.insertRecord(unbean);
		
		if(result.equals("success")) {
			
			session.setAttribute("status","success");
			RequestDispatcher rd = request.getRequestDispatcher("update_news.jsp");
			rd.forward(request, response);
			
		}
		else {
			
			session.setAttribute("status","fail");
			RequestDispatcher rd = request.getRequestDispatcher("update_news.jsp");
			rd.forward(request, response);
			
		}
		
		
		
		
		
		
		
		
		
		
		
	}

}
