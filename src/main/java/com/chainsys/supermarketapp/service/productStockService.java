package com.chainsys.supermarketapp.service;

import java.util.List;

import com.chainsys.supermarketapp.dao.ProductStockDAO;
import com.chainsys.supermarketapp.daofactory.DAOFactory;
import com.chainsys.supermarketapp.exception.DbException;
import com.chainsys.supermarketapp.exception.ServiceConstant;
import com.chainsys.supermarketapp.exception.ServiceException;
import com.chainsys.supermarketapp.model.ProductStock;

public class productStockService {
	ProductStockDAO ps = DAOFactory.getProductStockDAO();

	public int save(ProductStock productstock) throws ServiceException {
		try {
			return ps.save(productstock);
		} catch (DbException e) {
			throw new ServiceException(ServiceConstant.INVALID_SAVE);
		}

	}

	public int delete(ProductStock productstock) throws ServiceException {
		try {
			return ps.delete(productstock);
		} catch (DbException e) {
			throw new ServiceException(ServiceConstant.INVALID_DELETE);
		}

	}

	public int update(ProductStock productstock) throws ServiceException {
		try {
			return ps.update(productstock);
		} catch (DbException e) {
			throw new ServiceException(ServiceConstant.INVALID_UPDATE);
		}

	}

	public List<ProductStock> findAll() throws ServiceException {
		try {
			return ps.findAll();
		} catch (DbException e) {
			throw new ServiceException(ServiceConstant.INVALID_FIND);
		}

	}

	public int updateProductStock1(ProductStock productstock) throws ServiceException {
		try {
			return ps.updateProductStock1(productstock);
		} catch (DbException e) {
			throw new ServiceException(ServiceConstant.INVALID_UPDATE);
		}

	}
}
