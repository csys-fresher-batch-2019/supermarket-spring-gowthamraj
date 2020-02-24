package com.chainsys;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.supermarketapp.dao.impl.ProductStockImple;
import com.chainsys.supermarketapp.exception.DbException;
import com.chainsys.supermarketapp.model.ProductStock;
@WebServlet("/UpdatePStock")
public class UpdatePStock extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int prno = Integer.parseInt(request.getParameter("pno"));
		int qty = Integer.parseInt(request.getParameter("qut"));
		ProductStockImple psi = new ProductStockImple();
		ProductStock ps = new ProductStock();
		ps.setProductno(prno);
		ps.setQuantity(qty);
		boolean product;
		try {
			product = psi.isProductExists(ps.getProductno());
			if (product){
				psi.updateProductStock(ps);

				request.setAttribute("updateproduct", "Update Product Stock Suucesfully");
				RequestDispatcher dispatcher = request.getRequestDispatcher("UpdateProductStock.jsp");
				dispatcher.forward(request, response);
			} else{
				psi.updateProductStock(ps);
			
			request.setAttribute("updateproduct", "Update Product Stock Suucesfully");
			RequestDispatcher dispatcher = request.getRequestDispatcher("UpdateProductStock.jsp");
			dispatcher.forward(request, response);
			}
		} catch (DbException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
