package com.chainsys.supermarketapp.service;

import java.time.LocalDate;

import com.chainsys.supermarketapp.dao.CaseDAO;
import com.chainsys.supermarketapp.daofactory.DAOFactory;
import com.chainsys.supermarketapp.exception.DbException;
import com.chainsys.supermarketapp.exception.ServiceConstant;
import com.chainsys.supermarketapp.exception.ServiceException;
import com.chainsys.supermarketapp.model.OrderItem;

public class CaseService {

	CaseDAO cas = DAOFactory.getCaseDAO();

	public int countEmployee() throws ServiceException {
		try {
			return cas.countEmployee();
		} catch (DbException e) {
			throw new ServiceException(ServiceConstant.INVALID_FIND);
		}

	}

	public int findByTotalIncome(OrderItem bills) throws ServiceException {
		try {
			return cas.findByTotalIncome(bills);
		} catch (DbException e) {
			throw new ServiceException(ServiceConstant.INVALID_FIND);
		}
	}

	public int findByTodayIncome(LocalDate date) throws ServiceException {
		try {
			return cas.findByTodayIncome(date);
		} catch (DbException e) {
			throw new ServiceException(ServiceConstant.INVALID_FIND);
		}
	}
	// public List<Product> findByPrice(int min, int max) throws DbException;
//	public List<OrderItem> countCustomer(OrderItem bills) throws DbException;

}
