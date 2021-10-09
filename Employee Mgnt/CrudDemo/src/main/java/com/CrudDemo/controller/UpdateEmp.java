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


@WebServlet("/UpdateEmp")
public class UpdateEmp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EmpDao dao; 
	  
	@Override
	public void init() throws ServletException {
		dao = new EmpDao();
	} 
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String city = request.getParameter("city");
		
		Employee em = new Employee();
		em.setId(id);
		em.setName(name);
		em.setCity(city);
		
		int a = dao.updateEmp(em);
		
		if(a==1) {
			RequestDispatcher rd = request.getRequestDispatcher("Home.jsp");
			rd.forward(request, response);
		}
	}

	

}
