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

@WebServlet("/BillItem")
public class BillItem extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		BillOrderService boi = new BillOrderService();
		try {
			int cus = Integer.parseInt(request.getParameter("customer_no"));
			List<OrderItem> list = boi.findAllBillItems(cus);
						request.setAttribute("billitem", list);
			RequestDispatcher dispatcher = request.getRequestDispatcher("ViewBillItem.jsp");
			dispatcher.forward(request, response);
		} catch (ServiceException e) {
		} catch (DbException e) {
			e.printStackTrace();
		}

	}

}
