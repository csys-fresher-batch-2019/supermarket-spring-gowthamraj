package com.chainsys;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.supermarketapp.dao.impl.ProductImple;
import com.chainsys.supermarketapp.exception.DbException;
import com.chainsys.supermarketapp.model.Product;

@WebServlet("/UpdateProduct")
public class UpdateProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		ProductImple pi=new ProductImple();
		String pid=(request.getParameter("pid"));

		int price=Integer.parseInt(request.getParameter("pri"));
		Product p=new Product();
		p.setProductname(pid);
		p.setPrice(price);
	try {
		pi.updateproduct(p);
		request.setAttribute("product", "Update Succesfully");

		RequestDispatcher dispatcher = request.getRequestDispatcher("UpdateProduct.jsp");
		dispatcher.forward(request, response);
	} catch (DbException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}
}
