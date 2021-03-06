package com.chainsys;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.chainsys.supermarketapp.dao.ProductDAO;
import com.chainsys.supermarketapp.dao.ProductStockDAO;
import com.chainsys.supermarketapp.daofactory.DAOFactory;
import com.chainsys.supermarketapp.exception.DbException;
import com.chainsys.supermarketapp.exception.ServiceException;
import com.chainsys.supermarketapp.exception.ValidationException;
import com.chainsys.supermarketapp.model.Order;
import com.chainsys.supermarketapp.model.OrderItem;
import com.chainsys.supermarketapp.service.BillOrderService;

@WebServlet("/Bill")
@Service
public class Bill extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String cus = request.getParameter("cusnum");
		HttpSession sess = request.getSession();
		sess.setAttribute("cusno", cus);
		int cusno = Integer.valueOf(cus);
		String[] arr = request.getParameterValues("pid");
		int totalAmount = 0;
		Order order = new Order();
		order.setCustomerNo(cusno);

		try {
			ProductDAO v = DAOFactory.getProductDAO();
			for (String string : arr) {

				int produid = Integer.parseInt(string);
				int quantity = Integer.parseInt(request.getParameter("qty_" + string));

				int price = v.findOneProductPrice(produid);
				int tprice = price * quantity;

				OrderItem item = new OrderItem();
				item.setProductId(produid);
				item.setQuantity(quantity);
				item.setTotalAmount(tprice);
				order.addItem(item);

				totalAmount = totalAmount + tprice;
				item.getProductId();
			}

			order.setTotalAmount(totalAmount);
			order.setOrderedDate(LocalDateTime.now());
			order.setStatus("ORDERED");

			BillOrderService boi = new BillOrderService();
			ProductStockDAO v1 = DAOFactory.getProductStockDAO();
			boolean a = v1.productQuantity(order);
			System.out.println(a);
			if (a) {
				int aa = boi.save(order);
				order.setOrderId(aa);

				request.setAttribute("ORDER_DETAILS", order);

				RequestDispatcher dispatcher1 = request.getRequestDispatcher("BillReceipt.jsp");
				dispatcher1.forward(request, response);
			} else {

				request.setAttribute("ORDER_DETAILS", "Sufficient quantity not available for this product");

				RequestDispatcher dispatcher2 = request.getRequestDispatcher("Login.jsp");
				dispatcher2.forward(request, response);
			}
		} catch (DbException | ValidationException | ServiceException e) {
			request.setAttribute("ORDER_DETAILS", e.getMessage());
			RequestDispatcher dispatcher2 = request.getRequestDispatcher("orderitem.jsp");
			dispatcher2.forward(request, response);
		}
	}

}
