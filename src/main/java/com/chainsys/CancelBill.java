package com.chainsys;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import com.chainsys.supermarketapp.exception.DbException;
import com.chainsys.supermarketapp.exception.ServiceException;
import com.chainsys.supermarketapp.exception.ValidationException;
import com.chainsys.supermarketapp.model.Order;
import com.chainsys.supermarketapp.service.BillOrderService;

@WebServlet("/CancelBill")
@Service
public class CancelBill extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int cancel = Integer.parseInt(request.getParameter("cbills"));
		BillOrderService boi = new BillOrderService();
		Order bo = new Order();
		bo.setOrderId(cancel);
		try {
			boi.delete(bo);
		} catch (DbException | ServiceException | ValidationException e) {
			e.printStackTrace();
		}
		HttpSession session = request.getSession();
		session.setAttribute("cancel", "Bill Cancelled");
		response.sendRedirect("CancelBill.jsp");
	}

}
