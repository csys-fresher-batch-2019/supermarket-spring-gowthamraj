package com.chainsys.supermarketapp.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chainsys.supermarketapp.dao.BillOrderDAO;
import com.chainsys.supermarketapp.dao.LoginDAO;
import com.chainsys.supermarketapp.dao.ProductStockDAO;
import com.chainsys.supermarketapp.daofactory.DAOFactory;
import com.chainsys.supermarketapp.dto.MessagedTO;
import com.chainsys.supermarketapp.exception.DbException;
import com.chainsys.supermarketapp.model.Login;
import com.chainsys.supermarketapp.model.Order;

@Controller
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api")
public class SuperMarketAppController {
	
	LoginDAO lg = DAOFactory.getLoginDAO();
	BillOrderDAO bo = DAOFactory.getBillOrderDAO();
	ProductStockDAO ps = DAOFactory.getProductStockDAO();

	@PostMapping("/addloginregister")
	public MessagedTO addloginregister(@RequestParam("username") String username,
			@RequestParam("password") String password) throws DbException {
		MessagedTO msg = new MessagedTO();
		Login l = new Login();
		l.setUserName(username);
		l.setPassword(password);
		int a = lg.save(l);
		if (a == 1) {
			msg.setInfoMessage("register Success");
		} else {
			msg.setErrorMessage("register Failed");
		}
		return msg;
	}

	@GetMapping("/login")
	public MessagedTO login(@RequestParam("username") String username, @RequestParam("password") String password)
			throws DbException {
		MessagedTO msg = new MessagedTO();
		Login l = new Login();
		l.setUserName(username);
		l.setPassword(password);
		System.out.println(l);
		Login user = lg.findByUsernameAndPassword(l);
		if (user != null) {
			msg.setInfoMessage("Login Success");
		} else {
			msg.setErrorMessage("Login Failed");
		}
		return msg;
	}

	
	@PostMapping("/updateBillOrderbyamount")
	public MessagedTO updateBillOrderbyamount(@RequestParam("customerno") int customerno,
			@RequestParam("totalAmount") int totalAmount) throws DbException {
		MessagedTO msg = new MessagedTO();
		Order oo = new Order();
		oo.setCustomerNo(customerno);
		oo.setTotalAmount(totalAmount);
		int v = bo.update(oo);
		if (v == 1) {
			msg.setInfoMessage("Update bills details succesfully");
		} else {
			msg.setErrorMessage("updated failed");
		}
		return msg;
	}

	@PostMapping("/updateBillOrderbystatus")
	public MessagedTO updateBillOrderbystatus(@RequestParam("cusno") int cusno,
			@RequestParam("totalAmount") int totalAmount) throws DbException {
		MessagedTO msg = new MessagedTO();
		int v = bo.update(cusno);
		if (v == 1) {
			msg.setInfoMessage("Update bills details succesfully");
		} else {
			msg.setErrorMessage("updated failed");
		}
		return msg;
	}

}
