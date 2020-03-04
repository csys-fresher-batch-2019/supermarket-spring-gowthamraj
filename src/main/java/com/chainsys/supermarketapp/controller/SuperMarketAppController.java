package com.chainsys.supermarketapp.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chainsys.supermarketapp.dao.BillOrderDAO;
import com.chainsys.supermarketapp.dao.LoginDAO;
import com.chainsys.supermarketapp.dao.ProductDAO;
import com.chainsys.supermarketapp.dao.impl.ProductImple;
import com.chainsys.supermarketapp.daofactory.DAOFactory;
import com.chainsys.supermarketapp.dto.Messagedto;
import com.chainsys.supermarketapp.exception.DbException;
import com.chainsys.supermarketapp.model.Order;
import com.chainsys.supermarketapp.model.Product;

@Controller
@RestController
@RequestMapping("api")
public class SuperMarketAppController {

	LoginDAO lg = DAOFactory.getLoginDAO();
	ProductDAO pd = DAOFactory.getProductDAO();
	BillOrderDAO bo = DAOFactory.getBillOrderDAO();
	ProductImple pi = new ProductImple();

	@GetMapping("/displayproduct")
	public List<Product> displayproduct() throws DbException {

		List<Product> pro = pd.displayproduct();
		return pro;

	}

	@GetMapping("/displayBillOrder")
	public List<Order> displayBillOrder() throws DbException {
		List<Order> pro1 = bo.displayBillOrder();
		return pro1;

	}
	

	
	@GetMapping("/addproduct")
	public Messagedto addproduct(@RequestParam("product name") String prodcutname, @RequestParam("price") int price)
			throws DbException {
		Messagedto msg = new Messagedto();
		Product p = new Product();
		p.setProductname(prodcutname);
		p.setPrice(price);
		int v = pd.addproductDetails(p);
		if (v == 1) {
			msg.setInfoMessage("Added succesfully");
		} else {
			msg.setErrorMessage("Added Failed");
		}
		return msg;

	}
}
