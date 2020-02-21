package com.chainsys;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.supermarketapp.dao.impl.ProductImple;
import com.chainsys.supermarketapp.exception.DbException;
import com.chainsys.supermarketapp.model.Product;

public class AddProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ProductImple pi=new ProductImple();
		String pn=request.getParameter("pno");
		int price=Integer.parseInt(request.getParameter("pri"));
		Product p=new Product();
			p.setProductname(pn);
			p.setPrice(price);
			
			try {
				pi.addproductDetails(p);
				request.setAttribute("addproduct", "Adding Product Suucesfully");

				RequestDispatcher dispatcher = request.getRequestDispatcher("AddProduct.jsp");
				dispatcher.forward(request, response);
			} catch (DbException e) {
				e.printStackTrace();
			}
			
		}

}
