package com.chainsys.supermarketapp.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chainsys.supermarketapp.dao.EmployeeDAO;
import com.chainsys.supermarketapp.daofactory.DAOFactory;
import com.chainsys.supermarketapp.dto.MessagedTO;
import com.chainsys.supermarketapp.exception.DbException;
import com.chainsys.supermarketapp.model.Employee;

@Controller
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api")
public class EmployeeController {
	EmployeeDAO em = DAOFactory.getEmployeeDAO();

	@GetMapping("/employeeview")
	public List<Employee> displayEmployeeDetils() throws DbException {
		List<Employee> emp = em.findAll();
		return emp;
	}

	@PostMapping("/addemployee")
	public MessagedTO addemployee(@RequestBody Employee ee) throws DbException {

		MessagedTO msg = new MessagedTO();
		int v = em.save(ee);
		if (v == 1) {
			msg.setInfoMessage("Employee Added succesfully");
		} else {
			msg.setErrorMessage("Employee Added Failed");
		}
		return msg;
	}

	@PostMapping("/updateemployee")
	public MessagedTO updateemployee(@RequestParam("employeename") String employeename,
			@RequestParam("address") String address) throws DbException {

		MessagedTO msg = new MessagedTO();
		Employee ee = new Employee();
		ee.setEmployeeName(employeename);
		ee.setAddress(address);
		int v = em.update(ee);
		if (v == 1) {
			msg.setInfoMessage("updated succesfully");
		} else {
			msg.setErrorMessage("updated  Failed");
		}
		return msg;
	}

	@PostMapping("/deleteemployee")
	public MessagedTO deleteemployee(@RequestParam("employeename") String employeename) throws DbException {
		MessagedTO msg = new MessagedTO();
		Employee ee = new Employee();
		ee.setEmployeeName(employeename);
		int v = em.delete(ee);
		if (v == 1) {
			msg.setInfoMessage("delete employee succesfully");
		} else {
			msg.setErrorMessage("deleted failure");
		}
		return msg;
	}

}
