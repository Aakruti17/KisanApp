package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import com.bean.AddProductsBean;
import com.dao.AddProductsDAO;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/AddProductsServlet")
public class AddProductsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AddProductsServlet() {
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter pw = response.getWriter();
		
		HttpSession session = request.getSession();//session object created
		
		//read input
		String sname = request.getParameter("pname");
		String scompany = request.getParameter("pcompany");
		String scontents = request.getParameter("pcontents");
		int sprice = Integer.parseInt(request.getParameter("pprice"));
		String scategory = request.getParameter("pcategory");
		
		//transfer servlet data copy to bean object
		AddProductsBean apbean = new AddProductsBean();
		apbean.setPname(sname);
		apbean.setCname(scompany);
		apbean.setContents(scontents);
		apbean.setPrice(sprice);
		apbean.setCategory(scategory);
		
		//call DAO method
		AddProductsDAO apdao = new AddProductsDAO();
		String result = apdao.insertRecord(apbean);
		
		
		//process the result
		if(result.equals("success")) {
			
			session.setAttribute("status", "success"); //setAttribute("vname","value")
			RequestDispatcher rd = request.getRequestDispatcher("add_products.jsp");
			rd.forward(request, response);
		}
		else {
			
			session.setAttribute("status", "fail");
			RequestDispatcher rd = request.getRequestDispatcher("add_products.jsp");
			rd.forward(request, response);
			
		}
		
		
		
		
		
		
		
		
	}

}
