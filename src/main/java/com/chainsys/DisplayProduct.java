package com.chainsys;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.supermarketapp.dao.ProductDAO;
import com.chainsys.supermarketapp.daofactory.DAOFactory;
import com.chainsys.supermarketapp.exception.DbException;
import com.chainsys.supermarketapp.model.Product;

@WebServlet("/DisplayProduct")
public class DisplayProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// ProductAvailableValidation v = new ProductAvailableValidation();
		ProductDAO v = DAOFactory.getProductDAO();
		try {
			List<Product> list = v.findOneProductAvailable();
			request.setAttribute("order", list);
			RequestDispatcher dis = request.getRequestDispatcher("orderitem.jsp");
			dis.forward(request, response);
		} catch (DbException e) {
			e.printStackTrace();
		}

	}

}
