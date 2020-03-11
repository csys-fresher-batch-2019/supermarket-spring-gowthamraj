package com.chainsys.supermarketapp.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chainsys.supermarketapp.dao.ProductStockDAO;
import com.chainsys.supermarketapp.daofactory.DAOFactory;
import com.chainsys.supermarketapp.dto.MessagedTO;
import com.chainsys.supermarketapp.exception.DbException;
import com.chainsys.supermarketapp.model.ProductStock;

@RestController
@RequestMapping("api/productstock")
public class ProductStockController {
	ProductStockDAO ps = DAOFactory.getProductStockDAO();

	@GetMapping
	public List<ProductStock> displayProductStock() throws DbException {
		List<ProductStock> pro = ps.findAll();
		return pro;
	}

	@PostMapping("/addproductstock")
	public MessagedTO addproductstock(@RequestParam("productno") int productno, @RequestParam("stockid") int stockid,
			@RequestParam("quantity") int quantity, @RequestParam("productarrival") String productarrival,
			@RequestParam("experydate") String experydate) throws DbException {

		MessagedTO msg = new MessagedTO();
		ProductStock p = new ProductStock();
		p.setProductNo(productno);
		p.setStockId(stockid);
		p.setQuantity(quantity);
		p.setProductarrival(LocalDate.parse(productarrival));
		p.setExpiryDate(LocalDate.parse(experydate));

		int v = ps.save(p);
		if (v == 1) {
			msg.setInfoMessage("Added succesfully");
		} else {
			msg.setErrorMessage("Added Failed");
		}
		return msg;
	}

	@GetMapping("/updateproductstock")
	public MessagedTO updateproductstock(@RequestParam("productno") int productno,
			@RequestParam("quantity") int quantity) throws DbException {

		MessagedTO msg = new MessagedTO();
		ProductStock p = new ProductStock();
		p.setProductNo(productno);
		p.setQuantity(quantity);
		int v = ps.update(p);
		if (v == 1) {
			msg.setInfoMessage("updated succesfully");
		} else {
			msg.setErrorMessage("updated Failed");
		}
		return msg;

	}

	@GetMapping("/deleteproductstock")
	public MessagedTO deleteproductstock(@RequestParam("productno") int productno) throws DbException {

		MessagedTO msg = new MessagedTO();
		ProductStock p = new ProductStock();
		p.setProductNo(productno);

		int v = ps.delete(p);
		if (v == 1) {
			msg.setInfoMessage("updated succesfully");
		} else {
			msg.setErrorMessage("updated Failed");
		}
		return msg;

	}

}
