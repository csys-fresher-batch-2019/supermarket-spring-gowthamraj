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
import com.chainsys.supermarketapp.model.Employee;
import com.chainsys.supermarketapp.service.EmployeeService;

@WebServlet("/UpdateEmployee")
@Service
public class UpdateEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String ename = request.getParameter("en");
		String add = request.getParameter("ea");
		EmployeeService ei = new EmployeeService();
		Employee em = new Employee();
		em.setEmployeename(ename);
		em.setAddress(add);
		try {
			ei.update(em);
			request.setAttribute("updateproduct", "Update Employee Details Suucesfully");

			RequestDispatcher dispatcher = request.getRequestDispatcher("UpdateEmployee.jsp");
			dispatcher.forward(request, response);
		} catch (ServiceException e) {
			e.printStackTrace();
		}

	}

}
