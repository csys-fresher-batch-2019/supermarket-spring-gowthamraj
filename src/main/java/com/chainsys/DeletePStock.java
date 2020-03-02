package com.chainsys;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.chainsys.supermarketapp.dao.impl.ProductStockImple;
import com.chainsys.supermarketapp.exception.DbException;
import com.chainsys.supermarketapp.model.ProductStock;
@WebServlet("/DeletePStock")
@Service
public class DeletePStock extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int prno=Integer.parseInt(request.getParameter("pno"));
		ProductStockImple psi=new ProductStockImple();
		ProductStock ps = new ProductStock();
		ps.setProductno(prno);
		try {
			psi.deleteProductStock(ps);
			request.setAttribute("updateproduct", "Delete Product Stock Succesfully");
			RequestDispatcher dispatcher = request.getRequestDispatcher("DeleteProductStock.jsp");
			dispatcher.forward(request, response);
		} catch (DbException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		}
	}

