package com.chainsys;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ValidationException;

import org.springframework.stereotype.Service;
import com.chainsys.supermarketapp.exception.ServiceException;
import com.chainsys.supermarketapp.service.CaseService;

@WebServlet("/IncomeByDate")
@Service
public class IncomeByDate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CaseService ci = new CaseService();
		String date = request.getParameter("ibd");
		LocalDate d = LocalDate.parse(date);
		try {
			int amount = ci.findByTodayIncome(d);
			System.out.println(amount);
			request.setAttribute("billbydate", amount);
			RequestDispatcher dispatcher = request.getRequestDispatcher("IncomeByDate.jsp");
			dispatcher.forward(request, response);
		} catch (ServiceException e) {
			throw new ValidationException("There is some issue while getting the 'TODAY INCOME'");
		} 

	}

}
