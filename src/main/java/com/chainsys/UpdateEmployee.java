package com.chainsys;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.supermarketapp.dao.impl.EmployeeImpl;
import com.chainsys.supermarketapp.dao.impl.ProductStockImple;
import com.chainsys.supermarketapp.exception.DbException;
import com.chainsys.supermarketapp.model.Employee;
import com.chainsys.supermarketapp.model.ProductStock;
@WebServlet("/UpdateEmployee")
public class UpdateEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
		String ename=request.getParameter("en");
		String add=request.getParameter("ea");
		EmployeeImpl ei=new EmployeeImpl();
		Employee em=new Employee();
		em.setEmployeename(ename);
		em.setAddress(add);
		
		
		try {
		ei.updateEmployeeDetils(em);
			request.setAttribute("updateproduct", "Update Employee Details Suucesfully");

			RequestDispatcher dispatcher = request.getRequestDispatcher("UpdateEmployee.jsp");
			dispatcher.forward(request, response);

		} catch (DbException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}


}
