package com.chainsys;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;
import com.chainsys.supermarketapp.exception.ServiceException;
import com.chainsys.supermarketapp.model.ProductStock;
import com.chainsys.supermarketapp.service.productStockService;

@WebServlet("/DeletePStock")
@Service
public class DeletePStock extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int prno = Integer.parseInt(request.getParameter("pno"));
		productStockService psi = new productStockService();
		ProductStock ps = new ProductStock();
		ps.setProductNo(prno);
		try {
			psi.delete(ps);
			request.setAttribute("updateproduct", "Delete Product Stock Succesfully");
			RequestDispatcher dispatcher = request.getRequestDispatcher("DeleteProductStock.jsp");
			dispatcher.forward(request, response);
		} catch (ServiceException e) {
			request.setAttribute("updateproduct", e.getMessage());
			RequestDispatcher dispatcher = request.getRequestDispatcher("DeleteProductStock.jsp");
			dispatcher.forward(request, response);


		
		}
	}
}
