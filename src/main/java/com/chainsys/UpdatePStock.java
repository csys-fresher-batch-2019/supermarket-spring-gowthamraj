package com.chainsys;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.chainsys.supermarketapp.dao.ProductStockDAO;
import com.chainsys.supermarketapp.daofactory.DAOFactory;
import com.chainsys.supermarketapp.exception.DbException;
import com.chainsys.supermarketapp.exception.ServiceException;
import com.chainsys.supermarketapp.exception.ValidationException;
import com.chainsys.supermarketapp.model.ProductStock;
import com.chainsys.supermarketapp.service.productStockService;

@WebServlet("/UpdatePStock")
@Service
public class UpdatePStock extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int prno = Integer.parseInt(request.getParameter("pno"));
		int qty = Integer.parseInt(request.getParameter("qut"));
		ProductStockDAO v = DAOFactory.getProductStockDAO();
		productStockService psi = new productStockService();
		ProductStock ps = new ProductStock();
		ps.setProductNo(prno);
		ps.setQuantity(qty);
		// ProductValidation v = new ProductValidation();
		boolean product;
		try {
			product = v.isProductExists(ps.getProductNo());
			if (product) {
				psi.update(ps);

				request.setAttribute("updateproduct", "Update Product Stock Suucesfully");
				RequestDispatcher dispatcher = request.getRequestDispatcher("UpdateProductStock.jsp");
				dispatcher.forward(request, response);
			} else {
				psi.update(ps);

				request.setAttribute("updateproduct", "Update Product Stock Suucesfully");
				RequestDispatcher dispatcher = request.getRequestDispatcher("UpdateProductStock.jsp");
				dispatcher.forward(request, response);
			}
		} catch (DbException | ValidationException | ServiceException e) {

		}
	}
}
