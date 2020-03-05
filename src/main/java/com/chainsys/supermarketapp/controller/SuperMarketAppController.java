package com.chainsys.supermarketapp.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chainsys.supermarketapp.dao.BillOrderDAO;
import com.chainsys.supermarketapp.dao.LoginDAO;
import com.chainsys.supermarketapp.dao.ProductDAO;
import com.chainsys.supermarketapp.dao.ProductStockDAO;
import com.chainsys.supermarketapp.dao.impl.ProductImple;
import com.chainsys.supermarketapp.daofactory.DAOFactory;
import com.chainsys.supermarketapp.dto.Messagedto;
import com.chainsys.supermarketapp.exception.DbException;
import com.chainsys.supermarketapp.model.Login;
import com.chainsys.supermarketapp.model.Order;
import com.chainsys.supermarketapp.model.Product;
import com.chainsys.supermarketapp.model.ProductStock;

import lombok.Data;

@Controller
@RestController
@RequestMapping("api")
public class SuperMarketAppController {

	LoginDAO lg = DAOFactory.getLoginDAO();
	ProductDAO pd = DAOFactory.getProductDAO();
	BillOrderDAO bo = DAOFactory.getBillOrderDAO();
	ProductStockDAO ps = DAOFactory.getProductStockDAO();
	ProductImple pi = new ProductImple();

	@GetMapping("/displayBillOrder")
	public List<Order> displayBillOrder() throws DbException {
		List<Order> pro1 = bo.displayBillOrder();
		return pro1;

	}

	@GetMapping("/addloginregister")
	public Messagedto addloginregister(@RequestParam("username") String username,
			@RequestParam("password") String password) throws DbException {
		Messagedto msg = new Messagedto();
		Login l = new Login();
		l.setUsername(username);
		l.setPassword(password);
		int a = lg.add(l);
		if (a == 1) {
			msg.setInfoMessage("register Success");
		} else {
			msg.setErrorMessage("register Failed");
		}
		return msg;

	}

	@GetMapping("/displayProductStock")
	public List<ProductStock> displayProductStock() throws DbException {
		List<ProductStock> pro = ps.displayProductStock();
		return pro;
	}
	/*
	 * @GetMapping("/addproductstock") public Messagedto
	 * addproductstock(@RequestParam("productno") int productno,
	 * 
	 * @RequestParam("stockid") int stockid,@RequestParam("quantity") int quantity,
	 * 
	 * @RequestParam("productarrival") String productarrival,
	 * 
	 * @RequestParam("experydate") String experydate) throws DbException {
	 * 
	 * Messagedto msg = new Messagedto(); ProductStock p = new ProductStock();
	 * p.setProductno(productno); p.setStockid(stockid); p.setQuantity(quantity);
	 * 
	 * Date a=Date.valueOf(productarrival);
	 * 
	 * p.setProductarrival1(a); Date a1=Date.valueOf(experydate);
	 * p.setExperydate1(a1);
	 * 
	 * 
	 * int v = ps.addProductStock(p); if (v == 1) {
	 * msg.setInfoMessage("Added succesfully"); } else {
	 * msg.setErrorMessage("Added Failed"); } return msg; }
	 */	
	


	@GetMapping("/displayproduct")
	public List<Product> displayproduct() throws DbException {
		List<Product> pro = pd.displayproduct();
		return pro;

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
