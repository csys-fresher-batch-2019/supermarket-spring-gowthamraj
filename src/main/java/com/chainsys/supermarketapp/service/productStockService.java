package com.chainsys.supermarketapp.service;

import java.util.List;

import com.chainsys.supermarketapp.dao.ProductStockDAO;
import com.chainsys.supermarketapp.daofactory.DAOFactory;
import com.chainsys.supermarketapp.exception.DbException;
import com.chainsys.supermarketapp.exception.ServiceConstant;
import com.chainsys.supermarketapp.exception.ServiceException;
import com.chainsys.supermarketapp.exception.ValidationException;
import com.chainsys.supermarketapp.model.ProductStock;
import com.chainsys.supermarketapp.validator.Validator;

public class productStockService {
	public static ProductStockDAO ps = DAOFactory.getProductStockDAO();

	public int save(ProductStock productstock) throws ServiceException, ValidationException {
		try {
			Validator.validateProductStockForm(productstock);
			return ps.save(productstock);
		} catch (DbException e) {
			throw new ServiceException(ServiceConstant.INVALID_SAVE);
		}
	}

	public int delete(ProductStock productstock) throws ServiceException {
		try {
			Validator.validateProductStockForm(productstock);
			return ps.delete(productstock);
		} catch (DbException | ValidationException e) {
			throw new ServiceException(ServiceConstant.INVALID_DELETE);
		}
	}

	public int update(ProductStock productstock) throws ServiceException, ValidationException {
		try {
			Validator.validateProductStockForm(productstock);
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

	public int updateProductStock1(ProductStock productstock) throws ServiceException, ValidationException {
		try {
			Validator.validateProductStockForm(productstock);
			return ps.updateProductStockquantity(productstock);
		} catch (DbException e) {
			throw new ServiceException(ServiceConstant.INVALID_UPDATE);
		}
	}
}
