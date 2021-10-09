package com.CrudDemo.controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.CrudDemo.dao.EmpDao;
import com.CrudDemo.model.Employee;


@WebServlet("/BeforeUpdate")
public class BeforeUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EmpDao dao; 
	  
	@Override
	public void init() throws ServletException {
		dao = new EmpDao();
	}
   
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		Employee e = new Employee();
		e.setId(id);
		
		request.setAttribute("EmpDetails", e);
		
		if(id!=0) {
			ResultSet rs = dao.beforeUpdate(e);
			RequestDispatcher rd= request.getRequestDispatcher("Update-Employee.jsp");
			rd.forward(request, response);
		}
	}

}
