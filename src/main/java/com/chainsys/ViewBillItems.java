package com.chainsys;

import java.io.IOException;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.supermarketapp.dao.impl.BillOrderImple;
import com.chainsys.supermarketapp.exception.DbException;
import com.chainsys.supermarketapp.model.OrderItem;

@WebServlet("/ViewBillItems")
public class ViewBillItems extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int cus = Integer.parseInt(request.getParameter("customer_no"));
		BillOrderImple boi = new BillOrderImple();
		
			
			try {
				List<OrderItem> list = boi.viewBillItems(cus);

				request.setAttribute("billitem", list);
				RequestDispatcher dispatcher = request.getRequestDispatcher("ViewBillItem.jsp");
				dispatcher.forward(request, response);
			} catch (DbException e) {
				e.printStackTrace();
			}

		
	}

}
