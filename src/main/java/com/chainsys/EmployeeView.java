package com.chainsys;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.supermarketapp.dao.impl.EmployeeImpl;
import com.chainsys.supermarketapp.exception.DbException;
import com.chainsys.supermarketapp.model.Employee;

@WebServlet("/EmployeeView")
public class EmployeeView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		EmployeeImpl ei = new EmployeeImpl();


		try {
			List<Employee>	list = ei.displayEmployeeDetils();
			request.setAttribute("order", list);
			RequestDispatcher dis = request.getRequestDispatcher("EmployeeView.jsp");
			dis.forward(request, response);

		} catch (DbException e) {
			
			e.printStackTrace();
		}
		
	}

}
