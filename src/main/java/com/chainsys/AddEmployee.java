package com.chainsys;

import java.io.IOException;
import java.time.LocalDate;

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

@Service
@WebServlet("/AddEmployee")

public class AddEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String ename = request.getParameter("eno");
		String date = request.getParameter("dob");
		LocalDate dob = LocalDate.parse(date);
		String date1 = request.getParameter("doj");
		LocalDate doj = LocalDate.parse(date1);
		String add = request.getParameter("add");
		EmployeeService ei = new EmployeeService();
		Employee em = new Employee();
		em.setEmployeename(ename);
		em.setDob(dob);
		em.setDoj(doj);
		em.setAddress(add);
		try {
			ei.save(em);

			request.setAttribute("AddEmployee", "Adding Employee Record Suucesfully");
			RequestDispatcher dispatcher = request.getRequestDispatcher("AddEmployee.jsp");
			dispatcher.forward(request, response);
		} catch (ServiceException e) {
			
		}
	}
}
