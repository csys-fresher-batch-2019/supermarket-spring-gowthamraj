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
import com.chainsys.supermarketapp.model.Product;
import com.chainsys.supermarketapp.service.ProductService;

@WebServlet("/DeleteProduct")
@Service
public class DeleteProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ProductService pi = new ProductService();
		Product p = new Product();

		int d = Integer.parseInt(request.getParameter("pid"));
		p.setPid(d);
		try {
			pi.deleteproductAll(p);
			request.setAttribute("order", "Deleted Succesfully");

			RequestDispatcher dispatcher = request.getRequestDispatcher("DeleteProduct.jsp");
			dispatcher.forward(request, response);

		} catch (ServiceException e) {
			e.printStackTrace();
		}

	}

}
