package com.chainsys;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.chainsys.supermarketapp.dao.impl.EmployeeImpl;
import com.chainsys.supermarketapp.exception.DbException;
import com.chainsys.supermarketapp.model.Employee;
@WebServlet("/DeleteEmployee")
@Service
public class DeleteEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ename=request.getParameter("en");
		EmployeeImpl ei=new EmployeeImpl();
		Employee em=new Employee();
		em.setEmployeename(ename);
		
		try {
			ei.deleteEmployeeDetils(em);
			request.setAttribute("updateproduct", "Delete Employee Details Suucesfully");

				RequestDispatcher dispatcher = request.getRequestDispatcher("DeleteEmployee.jsp");
				dispatcher.forward(request, response);

			} catch (DbException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


		}


	}
