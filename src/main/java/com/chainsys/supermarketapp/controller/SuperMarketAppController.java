package com.chainsys.supermarketapp.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
import com.chainsys.supermarketapp.model.Product;
import com.chainsys.supermarketapp.model.ProductStock;

@Controller
@RestController
@RequestMapping("api")
public class SuperMarketAppController {
	EmployeeDAO em = DAOFactory.getEmployeeDAO();
	LoginDAO lg = DAOFactory.getLoginDAO();
	ProductDAO pd = DAOFactory.getProductDAO();
	BillOrderDAO bo = DAOFactory.getBillOrderDAO();
	ProductStockDAO ps = DAOFactory.getProductStockDAO();
	ProductImple pi = new ProductImple();

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

	@GetMapping("/updateproduct")
	public Messagedto updateproduct(@RequestParam("product name") String prodcutname, @RequestParam("price") int price)
			throws DbException {
		Messagedto msg = new Messagedto();
		Product p = new Product();
		p.setProductname(prodcutname);
		p.setPrice(price);
		int v = pd.updateproduct(p);

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
		int v = pd.deleteproductDetails(p);

		if (v == 1) {
			msg.setInfoMessage("updated succesfully");
		} else {
			msg.setErrorMessage("updated Failed");
		}
		return msg;
	}

	@GetMapping("/displayProductStock")
	public List<ProductStock> displayProductStock() throws DbException {
		List<ProductStock> pro = ps.displayProductStock();
		return pro;
	}
	/*
	 * @PostMapping("/addproductstock") public Messagedto
	 * addproductstock(@RequestParam("productno") int
	 * productno, @RequestParam("stockid") int stockid,@RequestParam("quantity") int
	 * quantity,
	 * 
	 * @RequestParam("productarrival") String
	 * productarrival, @RequestParam("experydate") String experydate) throws
	 * DbException {
	 * 
	 * Messagedto msg = new Messagedto(); ProductStock p = new ProductStock();
	 * p.setProductno(productno); p.setStockid(stockid); p.setQuantity(quantity);
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

	@GetMapping("/employeeview")
	public List<Employee> displayEmployeeDetils() throws DbException {
		List<Employee> emp = em.displayEmployeeDetils();
		return emp;
	}

	/*
	 * @GetMapping("/addemployee") public Messagedto
	 * addemployee(@RequestParam("employeeid") int employeeid,
	 * 
	 * @RequestParam("dob") String dob,
	 * 
	 * @RequestParam("doj") String doj,
	 * 
	 * @RequestParam("address") String address) throws DbException {
	 * 
	 * Messagedto msg = new Messagedto(); Employee ee=new Employee();
	 * ee.setEmployeeid(employeeid); LocalDate a=LocalDate.parse(dob); ee.setDob(a);
	 * LocalDate a1=LocalDate.parse(doj); ee.setDoj(a1); ee.setAddress(address); int
	 * v=em.addEmployeeDetils(ee); if (v == 1) {
	 * msg.setInfoMessage("Employee Added succesfully"); } else {
	 * msg.setErrorMessage("Employee Added Failed"); } return msg; }
	 */
	@PostMapping("/updateemployee")
	public Messagedto updateemployee(@RequestParam("employeename") String employeename,
			@RequestParam("address") String address) throws DbException {

		Messagedto msg = new Messagedto();
		Employee ee = new Employee();
		ee.setEmployeename(employeename);
		ee.setAddress(address);
		int v = em.updateEmployeeDetils(ee);
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
		int v = em.deleteEmployeeDetils(ee);
		if (v == 1) {
			msg.setInfoMessage("delete employee succesfully");
		} else {
			msg.setErrorMessage("deleted failure");
		}
		return msg;
	}

	@GetMapping("/displayBillOrder")
	public List<Order> displayBillOrder() throws DbException {
		List<Order> pro1 = bo.displayBillOrder();
		return pro1;

	}

	@GetMapping("/addBillOrder")
	public Messagedto addBillOrder(@RequestParam("orderId") int orderId, @RequestParam("customerno") int customerno,
			@RequestParam("totalAmount") int totalAmount) throws DbException {
		Messagedto msg = new Messagedto();
		Order oo = new Order();
		oo.setOrderId(orderId);
		oo.setCustomerno(customerno);
		oo.setTotalAmount(totalAmount);
		int v = bo.addBillOrder(oo);
		if (v == 1) {
			msg.setInfoMessage("delete employee succesfully");
		} else {
			msg.setErrorMessage("deleted failure");
		}
		return msg;
	}

	@GetMapping("/updateBillOrderbyamount")
		public Messagedto updateBillOrderbyamount(@RequestParam("customerno") int customerno,
				@RequestParam("totalAmount") int totalAmount) throws DbException
		{
			Messagedto msg=new Messagedto();
			Order oo=new Order();
			oo.setCustomerno(customerno);
			oo.setTotalAmount(totalAmount);
			int v= bo.updateBillOrder(oo);
			if(v==1)
			{
				msg.setInfoMessage("Update bills details succesfully");
			}else
			{
				msg.setErrorMessage("updated failed");
			}
			return msg;		
		}
	


}
