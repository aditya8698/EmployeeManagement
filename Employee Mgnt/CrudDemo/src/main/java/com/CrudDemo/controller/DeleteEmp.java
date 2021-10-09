package com.CrudDemo.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.CrudDemo.dao.EmpDao;
import com.CrudDemo.model.Employee;


@WebServlet("/DeleteEmp")
public class DeleteEmp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EmpDao dao; 
	  
	@Override
	public void init() throws ServletException {
		dao = new EmpDao();
	}   
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		Employee em = new Employee();
		em.setId(id);
		
		int a = dao.deleteEmp(em);
		
		if(a==1) {
			RequestDispatcher rd = request.getRequestDispatcher("Home.jsp");
			rd.include(request, response);
		}
	}

	

}
