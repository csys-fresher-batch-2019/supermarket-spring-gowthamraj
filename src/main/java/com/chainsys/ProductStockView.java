package com.chainsys;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.supermarketapp.dao.impl.ProductStockImple;
import com.chainsys.supermarketapp.exception.DbException;
import com.chainsys.supermarketapp.model.ProductStock;

@WebServlet("/ProductStockView")
public class ProductStockView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ProductStockImple psi = new ProductStockImple();
		try {
			List<ProductStock> list = psi.displayProductStock();
			request.setAttribute("order", list);
			RequestDispatcher dis = request.getRequestDispatcher("ProductStockView.jsp");
			dis.forward(request, response);

		} catch (DbException e) {
			e.printStackTrace();
		}
	}

}
