package com.chainsys;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.supermarketapp.dao.impl.CaseImple;
import com.chainsys.supermarketapp.exception.DbException;

public class IncomeByDate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CaseImple ci = new CaseImple();
		String date=request.getParameter("ibd");
		LocalDate d=LocalDate.parse(date);
		try {
			int amount = ci.todayIncome(d);
			System.out.println(amount);
			
			request.setAttribute("billbydate",amount);

			RequestDispatcher dispatcher = request.getRequestDispatcher("IncomeByDate.jsp");
			dispatcher.forward(request, response);
			
			
		} catch (DbException e) {
			e.printStackTrace();
		}
		
	}

}
