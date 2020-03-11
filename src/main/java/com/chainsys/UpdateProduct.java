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

@WebServlet("/UpdateProduct")
@Service
public class UpdateProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ProductService pi = new ProductService();
		String pid = (request.getParameter("pid"));

		int price = Integer.parseInt(request.getParameter("pri"));
		Product p = new Product();
		p.setProductName(pid);
		p.setPrice(price);
		try {
			pi.update(p);
			request.setAttribute("product", "Update Succesfully");

			RequestDispatcher dispatcher = request.getRequestDispatcher("UpdateProduct.jsp");
			dispatcher.forward(request, response);
		} catch (ServiceException | ValidationException e) {
			request.setAttribute("product", e.getMessage());
			RequestDispatcher dispatcher = request.getRequestDispatcher("UpdateProduct.jsp");
			dispatcher.forward(request, response);

			
		}

	}
}
