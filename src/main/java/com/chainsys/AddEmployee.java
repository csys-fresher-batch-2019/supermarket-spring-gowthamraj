package com.chainsys;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.supermarketapp.dao.impl.EmployeeImpl;
import com.chainsys.supermarketapp.exception.DbException;
import com.chainsys.supermarketapp.model.Employee;

public class AddEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ename=request.getParameter("eno");
		String date=request.getParameter("dob");
		LocalDate dob=LocalDate.parse(date);
		String date1=request.getParameter("doj");
		LocalDate doj=LocalDate.parse(date1);
		String add=request.getParameter("add");
		EmployeeImpl ei=new EmployeeImpl();
		Employee em=new Employee();
		em.setEmployeename(ename);
		em.setDob(dob);
		em.setDoj(doj);
		em.setAddress(add);
		try {
			ei.addEmployeeDetils(em);
			request.setAttribute("AddEmployee", "Adding Employee Record Suucesfully");
			RequestDispatcher dispatcher = request.getRequestDispatcher("AddEmployee.jsp");
			dispatcher.forward(request, response);

		} catch (DbException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
