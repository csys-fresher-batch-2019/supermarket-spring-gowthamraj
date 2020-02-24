package com.chainsys;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chainsys.supermarketapp.dao.impl.BillOrderImple;
import com.chainsys.supermarketapp.exception.DbException;
import com.chainsys.supermarketapp.model.Order;
@WebServlet("/CancelBill")
public class CancelBill extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int cancel = Integer.parseInt(request.getParameter("cbills"));
		BillOrderImple boi = new BillOrderImple();
		Order bo = new Order();
		bo.setOrderId(cancel);
		try {
			boi.deleteBillOrder(bo);
		} catch (DbException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HttpSession session = request.getSession();
		session.setAttribute("cancel", "Bill Cancelled");
		response.sendRedirect("CancelBill.jsp");
	}

	
}
