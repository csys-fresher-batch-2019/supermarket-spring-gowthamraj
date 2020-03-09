package com.chainsys;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;
import com.chainsys.supermarketapp.exception.ServiceException;
import com.chainsys.supermarketapp.service.CaseService;

@WebServlet("/EmployeeCount")
@Service
public class EmployeeCount extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		CaseService ci = new CaseService();

		try {
			int total = ci.countEmployee();

			request.setAttribute("Total", total);

			RequestDispatcher dispatcher = request.getRequestDispatcher("EmployeeCount.jsp");
			dispatcher.forward(request, response);

		} catch (ServiceException e1) {
			e1.printStackTrace();
		}

	}

}
