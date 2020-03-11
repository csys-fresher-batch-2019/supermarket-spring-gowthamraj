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
import com.chainsys.supermarketapp.exception.ValidationException;
import com.chainsys.supermarketapp.model.Product;
import com.chainsys.supermarketapp.service.ProductService;

@WebServlet("/AddProduct")
@Service
public class AddProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("static-access")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ProductService pi = new ProductService();
		String pn = request.getParameter("pno");
		int price = Integer.parseInt(request.getParameter("pri"));
		Product p = new Product();
		p.setProductName(pn);
		p.setPrice(price);

		try {
			pi.save(p);
			request.setAttribute("addproduct", "Adding Product Suucesfully");

			RequestDispatcher dispatcher = request.getRequestDispatcher("AddProduct.jsp");
			dispatcher.forward(request, response);
		} catch (ServiceException | ValidationException e) {
			request.setAttribute("addproduct",e.getMessage());

			RequestDispatcher dispatcher = request.getRequestDispatcher("AddProduct.jsp");
			dispatcher.forward(request, response);
		}
		

	}
}