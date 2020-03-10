package com.chainsys;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import com.chainsys.supermarketapp.exception.DbException;
import com.chainsys.supermarketapp.exception.ServiceException;
import com.chainsys.supermarketapp.service.BillOrderService;

@WebServlet("/BillPayment")
@Service
public class BillPayment extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BillOrderService boi = new BillOrderService();
		HttpSession sess = request.getSession(false);
		String cusno = (String) sess.getAttribute("cusno");
		int cus = Integer.valueOf(cusno);
		try {
			boi.update(cus);

			String order = "PAyment Succesful";
			request.setAttribute("ORDER_DETAILS", order);

			RequestDispatcher dispatcher = request.getRequestDispatcher("BillPay.jsp");
			dispatcher.forward(request, response);
		} catch (ServiceException e) {
		} catch (DbException e) {
			e.printStackTrace();
		}
	}

}
