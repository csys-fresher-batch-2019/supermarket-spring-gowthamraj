package com.chainsys;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.chainsys.supermarketapp.dao.impl.CaseImple;
import com.chainsys.supermarketapp.exception.DbException;
@WebServlet("/EmployeeCount")
@Service
public class EmployeeCount extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		CaseImple ci = new CaseImple();
		
		try {
			int total=ci.employeeCount();
			
			request.setAttribute("Total",total);

			RequestDispatcher dispatcher = request.getRequestDispatcher("EmployeeCount.jsp");
			dispatcher.forward(request, response);
			
		}
		catch (DbException e1) {
			e1.printStackTrace();
		}

		
	}

	
}
