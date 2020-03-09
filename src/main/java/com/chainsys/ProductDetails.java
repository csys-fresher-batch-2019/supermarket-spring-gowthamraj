package com.chainsys;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.chainsys.supermarketapp.exception.ServiceException;
import com.chainsys.supermarketapp.model.Product;
import com.chainsys.supermarketapp.service.ProductService;

@WebServlet("/ProductDetails")
public class ProductDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ProductService pi = new ProductService();
		try {
			List<Product> list = pi.findAll();
			request.setAttribute("order", list);
			RequestDispatcher dis = request.getRequestDispatcher("ProductDetails.jsp");
			dis.forward(request, response);
		} catch ( ServiceException e) {

			e.printStackTrace();
		}

	}

}
