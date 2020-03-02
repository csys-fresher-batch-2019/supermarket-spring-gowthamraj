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
import com.chainsys.supermarketapp.model.OrderItem;
@WebServlet("/TotalIncome")
@Service
public class TotalIncome extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CaseImple ci = new CaseImple();
		OrderItem b = new OrderItem();
		try {
			int tot=ci.totalIncome(b);
			System.out.println(tot);
			request.setAttribute("total", tot);
			RequestDispatcher dispatcher = request.getRequestDispatcher("TotalAmount.jsp");
			dispatcher.forward(request, response);
		} catch (DbException e) {

			e.printStackTrace();
		}	}
}
