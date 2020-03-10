package com.chainsys.supermarketapp.service;

import java.util.List;

import com.chainsys.supermarketapp.dao.BillOrderDAO;
import com.chainsys.supermarketapp.daofactory.DAOFactory;
import com.chainsys.supermarketapp.exception.DbException;
import com.chainsys.supermarketapp.exception.ServiceConstant;
import com.chainsys.supermarketapp.exception.ServiceException;
import com.chainsys.supermarketapp.model.Order;
import com.chainsys.supermarketapp.model.OrderItem;

public class BillOrderService {

	BillOrderDAO bo = DAOFactory.getBillOrderDAO();

	public int save(Order billorder) throws ServiceException, DbException {
		try {
			return bo.save(billorder);
		} catch (DbException e) {

			throw new ServiceException(ServiceConstant.INVALID_SAVE);
		}
	}

	public List<Order> findAll() throws ServiceException, DbException {
		try {
			return bo.findAll();
		} catch (DbException e) {
			throw new ServiceException(ServiceConstant.INVALID_FIND);
		}
	}

	public int update(Order billorder) throws ServiceException, DbException {
		try {
			return bo.update(billorder);
		} catch (DbException e) {
			throw new ServiceException(ServiceConstant.INVALID_UPDATE);
		}
	}

	public int delete(Order billorder) throws ServiceException, DbException {
		try {
			return bo.delete(billorder);
		} catch (DbException e) {
			throw new ServiceException(ServiceConstant.INVALID_DELETE);
		}
	}

	public int update(int cusno) throws ServiceException, DbException {
		try {
			return bo.update(cusno);
		} catch (DbException e) {
			throw new ServiceException(ServiceConstant.INVALID_UPDATE);
		}
	}

	public List<OrderItem> findAllBillItems(int billNo) throws ServiceException, DbException {
		try {
			return bo.findAllBillItems(billNo);
		} catch (DbException e) {
			throw new ServiceException(ServiceConstant.INVALID_FIND);
		}
	}

}
