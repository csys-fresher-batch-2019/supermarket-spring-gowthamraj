package com.chainsys.supermarketapp.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chainsys.supermarketapp.dao.BillOrderDAO;
import com.chainsys.supermarketapp.dao.EmployeeDAO;
import com.chainsys.supermarketapp.dao.LoginDAO;
import com.chainsys.supermarketapp.dao.ProductDAO;
import com.chainsys.supermarketapp.dao.ProductStockDAO;
import com.chainsys.supermarketapp.dao.impl.ProductImple;
import com.chainsys.supermarketapp.daofactory.DAOFactory;
import com.chainsys.supermarketapp.dto.Messagedto;
import com.chainsys.supermarketapp.exception.DbException;
import com.chainsys.supermarketapp.model.Employee;
import com.chainsys.supermarketapp.model.Login;
import com.chainsys.supermarketapp.model.Order;
import com.chainsys.supermarketapp.model.OrderItem;
import com.chainsys.supermarketapp.model.Product;


@Controller
@RestController
@RequestMapping("api")
public class SuperMarketAppController {
	EmployeeDAO em = DAOFactory.getEmployeeDAO();
	LoginDAO lg = DAOFactory.getLoginDAO();
	ProductDAO pd = DAOFactory.getProductDAO();
	BillOrderDAO bo = DAOFactory.getBillOrderDAO();
	ProductStockDAO ps = DAOFactory.getProductStockDAO();

	@GetMapping("/addloginregister")
	public Messagedto addloginregister(@RequestParam("username") String username,
			@RequestParam("password") String password) throws DbException {
		Messagedto msg = new Messagedto();
		Login l = new Login();
		l.setUsername(username);
		l.setPassword(password);
		int a = lg.save(l);
		if (a == 1) {
			msg.setInfoMessage("register Success");
		} else {
			msg.setErrorMessage("register Failed");
		}
		return msg;
	}

	@GetMapping("/displayproduct")
	public List<Product> displayproduct() throws DbException {
		List<Product> pro = pd.findAll();
		return pro;

	}

	@GetMapping("/addproduct")
	public Messagedto addproduct(@RequestParam("product name") String prodcutname, @RequestParam("price") int price)
			throws DbException {
		Messagedto msg = new Messagedto();
		Product p = new Product();
		p.setProductname(prodcutname);
		p.setPrice(price);
		int v = pd.save(p);
		if (v == 1) {
			msg.setInfoMessage("Added succesfully");
		} else {
			msg.setErrorMessage("Added Failed");
		}
		return msg;

	}

	@GetMapping("/updateproduct")
	public Messagedto updateproduct(@RequestParam("product name") String prodcutname, @RequestParam("price") int price)
			throws DbException {
		Messagedto msg = new Messagedto();
		Product p = new Product();
		p.setProductname(prodcutname);
		p.setPrice(price);
		int v = pd.update(p);

		if (v == 1) {
			msg.setInfoMessage("updated succesfully");
		} else {
			msg.setErrorMessage("updated Failed");
		}
		return msg;
	}

	@GetMapping("/deleteproduct")
	public Messagedto deleteproduct(@RequestParam("product id") int pid) throws DbException {
		Messagedto msg = new Messagedto();
		Product p = new Product();
		p.setPid(pid);
		int v = pd.delete(p);

		if (v == 1) {
			msg.setInfoMessage("updated succesfully");
		} else {
			msg.setErrorMessage("updated Failed");
		}
		return msg;
	}

	
	@GetMapping("/employeeview")
	public List<Employee> displayEmployeeDetils() throws DbException {
		List<Employee> emp = em.findAll();
		return emp;
	}

	@GetMapping("/addemployee")
	public Messagedto addemployee(@RequestParam("employeename") String employeename, @RequestParam("dob") String dob,
			@RequestParam("doj") String doj, @RequestParam("address") String address) throws DbException {

		Messagedto msg = new Messagedto();
		Employee ee = new Employee();
		ee.setEmployeename(employeename);
		LocalDate a = LocalDate.parse(dob);
		ee.setDob(a);
		LocalDate a1 = LocalDate.parse(doj);
		ee.setDoj(a1);
		ee.setAddress(address);
		int v = em.save(ee);
		if (v == 1) {
			msg.setInfoMessage("Employee Added succesfully");
		} else {
			msg.setErrorMessage("Employee Added Failed");
		}
		return msg;
	}

	@PostMapping("/updateemployee")
	public Messagedto updateemployee(@RequestParam("employeename") String employeename,
			@RequestParam("address") String address) throws DbException {

		Messagedto msg = new Messagedto();
		Employee ee = new Employee();
		ee.setEmployeename(employeename);
		ee.setAddress(address);
		int v = em.update(ee);
		if (v == 1) {
			msg.setInfoMessage("updated succesfully");
		} else {
			msg.setErrorMessage("updated  Failed");
		}
		return msg;
	}

	@GetMapping("/deleteemployee")
	public Messagedto deleteemployee(@RequestParam("employeename") String employeename) throws DbException {
		Messagedto msg = new Messagedto();
		Employee ee = new Employee();
		ee.setEmployeename(employeename);
		int v = em.delete(ee);
		if (v == 1) {
			msg.setInfoMessage("delete employee succesfully");
		} else {
			msg.setErrorMessage("deleted failure");
		}
		return msg;
	}

	@GetMapping("/displayBillOrder")
	public List<Order> displayBillOrder() throws DbException {
		List<Order> pro1 = bo.findAll();
		return pro1;

	}

	@GetMapping("/updateBillOrderbyamount")
	public Messagedto updateBillOrderbyamount(@RequestParam("customerno") int customerno,
			@RequestParam("totalAmount") int totalAmount) throws DbException {
		Messagedto msg = new Messagedto();
		Order oo = new Order();
		oo.setCustomerno(customerno);
		oo.setTotalAmount(totalAmount);
		int v = bo.update(oo);
		if (v == 1) {
			msg.setInfoMessage("Update bills details succesfully");
		} else {
			msg.setErrorMessage("updated failed");
		}
		return msg;
	}

	@GetMapping("/updateBillOrderbystatus")
	public Messagedto updateBillOrderbystatus(@RequestParam("cusno") int cusno,
			@RequestParam("totalAmount") int totalAmount) throws DbException {
		Messagedto msg = new Messagedto();
		int v = bo.update(cusno);
		if (v == 1) {
			msg.setInfoMessage("Update bills details succesfully");
		} else {
			msg.setErrorMessage("updated failed");
		}
		return msg;
	}

	@GetMapping("/viewBillItems")
	public List<OrderItem> viewBillItems(@RequestParam("billNo") int billNo) throws DbException {

		List<OrderItem> list = bo.findAllBillItems(billNo);
		return list;

	}
}
