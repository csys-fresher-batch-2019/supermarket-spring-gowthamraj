package com.chainsys;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chainsys.supermarketapp.dao.impl.BillOrderImple;
import com.chainsys.supermarketapp.exception.DbException;
@WebServlet("/BillPayment")
public class BillPayment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BillOrderImple boi=new BillOrderImple();
		
		HttpSession sess=request.getSession(false);
		String cusno=(String)sess.getAttribute("cusno");
		int cus = Integer.valueOf(cusno);
		
		
		try {
			boi.updateBillStatus(cus);
			String order="PAyment Succesful";
			request.setAttribute("ORDER_DETAILS", order);

			RequestDispatcher dispatcher = request.getRequestDispatcher("BillPay.jsp");
			dispatcher.forward(request, response);
		} catch (DbException e) {
		
			e.printStackTrace();
		}
	}

	
}
