package com.chainsys.supermarketapp.service;

import java.util.List;

import com.chainsys.supermarketapp.dao.EmployeeDAO;
import com.chainsys.supermarketapp.daofactory.DAOFactory;
import com.chainsys.supermarketapp.exception.DbException;
import com.chainsys.supermarketapp.exception.ServiceConstant;
import com.chainsys.supermarketapp.exception.ServiceException;
import com.chainsys.supermarketapp.exception.ValidationException;
import com.chainsys.supermarketapp.model.Employee;
import com.chainsys.supermarketapp.validator.Validator;

public class EmployeeService {

	EmployeeDAO emp = DAOFactory.getEmployeeDAO();

	public int save(Employee employee) throws ServiceException, ValidationException {
		try {
			Validator.validateEmployeeForm(employee);
			return emp.save(employee);
		} catch (DbException e) {
			throw new ServiceException(ServiceConstant.INVALID_SAVE);
		}
	}

	public int delete(Employee employee) throws ServiceException, ValidationException {
		try {
			Validator.validateEmployeeForm(employee);
			return emp.delete(employee);
		} catch (DbException e) {
			throw new ServiceException(ServiceConstant.INVALID_DELETE);
		}
	}

	public int update(Employee employee) throws ServiceException, ValidationException {
		try {
			Validator.validateEmployeeForm(employee);
			return emp.update(employee);
		} catch (DbException e) {
			throw new ServiceException(ServiceConstant.INVALID_UPDATE);
		}

	}

	public List<Employee> findAll() throws ServiceException {
		try {
			return emp.findAll();
		} catch (DbException e) {
			throw new ServiceException(ServiceConstant.INVALID_FIND);

		}
	}
}
