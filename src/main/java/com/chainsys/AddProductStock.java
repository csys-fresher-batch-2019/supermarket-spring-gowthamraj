package com.chainsys;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.chainsys.supermarketapp.exception.ServiceException;
import com.chainsys.supermarketapp.model.ProductStock;
import com.chainsys.supermarketapp.service.productStockService;

@WebServlet("/AddProductStock")

public class AddProductStock extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int prno = Integer.parseInt(request.getParameter("pno"));
		int qty = Integer.parseInt(request.getParameter("qut"));
		String ad = request.getParameter("ad");
		LocalDate a = LocalDate.parse(ad);
		String ed = request.getParameter("ed");
		LocalDate ex = LocalDate.parse(ed);
		productStockService psi = new productStockService();
		ProductStock ps = new ProductStock();

		ps.setProductno(prno);
		ps.setQuantity(qty);
		ps.setProductarrival(a);
		ps.setExperydate(ex);
		boolean product = ps.getExperydate().isAfter(ps.getProductarrival());
		System.out.println(product);

		if (product) {

			try {
				psi.save(ps);

				request.setAttribute("addstock", "Adding Stock Details Suucesfully");

				RequestDispatcher dispatcher = request.getRequestDispatcher("AddProductStock.jsp");
				dispatcher.forward(request, response);
			} catch (ServiceException e) {

			}

		} else {
			request.setAttribute("addstock", "INVALID EXPERY DATE");

			RequestDispatcher dispatcher = request.getRequestDispatcher("AddProductStock.jsp");
			dispatcher.forward(request, response);
		}

	}
}
