package com.chainsys.supermarketapp.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chainsys.supermarketapp.dao.ProductDAO;
import com.chainsys.supermarketapp.daofactory.DAOFactory;
import com.chainsys.supermarketapp.dto.MessagedTO;
import com.chainsys.supermarketapp.exception.DbException;
import com.chainsys.supermarketapp.model.Product;

@Controller
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/product")

public class ProductController {
	
	ProductDAO pd = DAOFactory.getProductDAO();
	
	@GetMapping("/displayproduct")
	public List<Product> displayproduct() throws DbException {
		List<Product> pro = pd.findAll();
		return pro;

	}

	@PostMapping("/addproduct")
	public MessagedTO addproduct(@RequestParam("product name") String prodcutname, @RequestParam("price") int price)
			throws DbException {
		MessagedTO msg = new MessagedTO();
		Product p = new Product();
		p.setProductName(prodcutname);
		p.setPrice(price);
		int v = pd.save(p);
		if (v == 1) {
			msg.setInfoMessage("Added succesfully");
		} else {
			msg.setErrorMessage("Added Failed");
		}
		return msg;

	}

	@PostMapping("/updateproduct")
	public MessagedTO updateproduct(@RequestParam("product name") String prodcutname, @RequestParam("price") int price)
			throws DbException {
		MessagedTO msg = new MessagedTO();
		Product p = new Product();
		p.setProductName(prodcutname);
		p.setPrice(price);
		int v = pd.update(p);

		if (v == 1) {
			msg.setInfoMessage("updated succesfully");
		} else {
			msg.setErrorMessage("updated Failed");
		}
		return msg;
	}

	@PostMapping("/deleteproduct")
	public MessagedTO deleteproduct(@RequestParam("productname") String productname) throws DbException {
		MessagedTO msg = new MessagedTO();
		Product p = new Product();
		p.setProductName(productname);
		int v = pd.delete(p);

		if (v == 1) {
			msg.setInfoMessage("deleted succesfully");
		} else {
			msg.setErrorMessage("deleted Failed");
		}
		return msg;
	}



}
