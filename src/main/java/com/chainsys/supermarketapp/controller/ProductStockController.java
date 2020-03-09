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
import com.chainsys.supermarketapp.dto.Messagedto;
import com.chainsys.supermarketapp.exception.DbException;
import com.chainsys.supermarketapp.model.ProductStock;

@RestController
@RequestMapping("api/productstock")
public class ProductStockController {
	ProductStockDAO ps = DAOFactory.getProductStockDAO();

	@GetMapping
	public List<ProductStock> displayProductStock() throws DbException {
		List<ProductStock> pro = ps.displayProductStock();
		return pro;
	}

	@PostMapping("/addproductstock")
	public Messagedto addproductstock(@RequestParam("productno") int productno, @RequestParam("stockid") int stockid,
			@RequestParam("quantity") int quantity, @RequestParam("productarrival") String productarrival,
			@RequestParam("experydate") String experydate) throws DbException {

		Messagedto msg = new Messagedto();
		ProductStock p = new ProductStock();
		p.setProductno(productno);
		p.setStockid(stockid);
		p.setQuantity(quantity);
		p.setProductarrival(LocalDate.parse(productarrival));
		p.setExperydate(LocalDate.parse(experydate));

		int v = ps.addProductStock(p);
		if (v == 1) {
			msg.setInfoMessage("Added succesfully");
		} else {
			msg.setErrorMessage("Added Failed");
		}
		return msg;
	}

	@GetMapping("/updateproductstock")
	public Messagedto updateproductstock(@RequestParam("productno") int productno,
			@RequestParam("quantity") int quantity) throws DbException {

		Messagedto msg = new Messagedto();
		ProductStock p = new ProductStock();
		p.setProductno(productno);
		p.setQuantity(quantity);
		int v = ps.updateProductStock(p);
		if (v == 1) {
			msg.setInfoMessage("updated succesfully");
		} else {
			msg.setErrorMessage("updated Failed");
		}
		return msg;

	}

	@GetMapping("/deleteproductstock")
	public Messagedto deleteproductstock(@RequestParam("productno") int productno) throws DbException {

		Messagedto msg = new Messagedto();
		ProductStock p = new ProductStock();
		p.setProductno(productno);

		int v = ps.deleteProductStock(p);
		if (v == 1) {
			msg.setInfoMessage("updated succesfully");
		} else {
			msg.setErrorMessage("updated Failed");
		}
		return msg;

	}

}
