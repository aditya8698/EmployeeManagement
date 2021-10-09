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


@WebServlet("/AddEmp")
public class AddEmp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 EmpDao dao; 
	  
		@Override
		public void init() throws ServletException {
			dao = new EmpDao();
		}   
    
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String city = request.getParameter("city");
		float salary  = Float.parseFloat(request.getParameter("salary"));
		
		Employee emp = new Employee();
		emp.setName(name);
		emp.setCity(city);
		emp.setSalary(salary);
		
		int a = dao.insertData(emp);
		
		if(a==1) {
			RequestDispatcher rd =  request.getRequestDispatcher("Home.jsp");
			rd.forward(request, response);
		}
	}

}
