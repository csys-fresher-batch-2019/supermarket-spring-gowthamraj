package com.chainsys.supermarketapp.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chainsys.supermarketapp.dao.BillOrderDAO;
import com.chainsys.supermarketapp.dao.ProductDAO;
import com.chainsys.supermarketapp.dao.ProductStockDAO;
import com.chainsys.supermarketapp.daofactory.DAOFactory;
import com.chainsys.supermarketapp.exception.DbException;
import com.chainsys.supermarketapp.exception.ServiceException;
import com.chainsys.supermarketapp.exception.ValidationException;
import com.chainsys.supermarketapp.model.Order;
import com.chainsys.supermarketapp.model.OrderDTO;
import com.chainsys.supermarketapp.model.OrderItem;
import com.chainsys.supermarketapp.model.OrderItemDTO;
import com.chainsys.supermarketapp.service.BillOrderService;

@Controller
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/Bill")
public class BillsViewController {
	BillOrderDAO bo = DAOFactory.getBillOrderDAO();

	@GetMapping("/displayBillOrder")
	public List<Order> displayBillOrder() throws DbException {
		List<Order> pro1 = bo.findAll();
		return pro1;

	}

	@GetMapping("/viewBillItems")
	public List<OrderItem> viewBillItems(@RequestParam("billNo") int billNo) throws DbException {

		List<OrderItem> list = bo.findAllBillItems(billNo);
		return list;

	}

	@GetMapping("/updatebills")
	public void updatebills(@RequestParam("cusno") int cusno) throws DbException {
		bo.update(cusno);

	}

	@GetMapping("/findByCustomerNumber")
	public List<Order> findByCustomerNumber(@RequestParam("customerNumber") int customerNumber) throws DbException {
		List<Order> list = bo.findByCustomerNumber(customerNumber);
		return list;
	}

	@PostMapping("addOrder")
	public void addOrder(@RequestBody OrderDTO orderDTO) {

		save(orderDTO);
	}

	protected void save(OrderDTO orderDTO) {

		int cusno = orderDTO.getCustomerId();

		int totalAmount = 0;
		Order order = new Order();
		order.setCustomerNo(cusno);

		try {
			ProductDAO v = DAOFactory.getProductDAO();
			for (OrderItemDTO itemDTO : orderDTO.getItems()) {

				int productID = itemDTO.getItemId();
				int quantity = itemDTO.getQuantity();
				int price = v.findOneProductPrice(productID);
				int tprice = price * quantity;

				OrderItem item = new OrderItem();
				item.setProductId(productID);
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

			if (a) {
				int aa = boi.save(order);
				order.setOrderId(aa);
			}
		} catch (DbException | ValidationException | ServiceException e) {
			e.printStackTrace();
		}
	}

}
