package com.chainsys;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.chainsys.supermarketapp.dao.BillOrderDAO;
import com.chainsys.supermarketapp.daofactory.DAOFactory;
import com.chainsys.supermarketapp.exception.DbException;
import com.chainsys.supermarketapp.model.Order;

@WebServlet("/ViewBills")
public class ViewBills extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		BillOrderDAO boi = DAOFactory.getBillOrderDAO();
		try {
			List<Order> list = boi.findAll();
			System.out.println(list.size());
			request.setAttribute("View", list);
			RequestDispatcher dis = request.getRequestDispatcher("ViewBills.jsp");
			dis.forward(request, response);
		} catch (DbException e) {
			request.setAttribute("View", e.getMessage());
			RequestDispatcher dis = request.getRequestDispatcher("ViewBills.jsp");
			dis.forward(request, response);

			
		}

	}
}
