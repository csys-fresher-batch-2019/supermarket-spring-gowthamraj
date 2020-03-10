package com.chainsys;

import java.io.IOException;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.chainsys.supermarketapp.exception.DbException;
import com.chainsys.supermarketapp.exception.ServiceException;
import com.chainsys.supermarketapp.model.OrderItem;
import com.chainsys.supermarketapp.service.BillOrderService;

@WebServlet("/ViewBillItems")
public class ViewBillItems extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int cus = Integer.parseInt(request.getParameter("customer_no"));
		BillOrderService boi = new BillOrderService();

		try {
			List<OrderItem> list = boi.findAllBillItems(cus);
			request.setAttribute("billitem", list);
			RequestDispatcher dispatcher = request.getRequestDispatcher("ViewBillItem.jsp");
			dispatcher.forward(request, response);
		} catch (ServiceException | DbException e) {
			e.printStackTrace();
		}

	}

}
