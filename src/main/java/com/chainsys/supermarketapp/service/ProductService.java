package com.chainsys.supermarketapp.service;

import java.util.List;

import com.chainsys.supermarketapp.dao.ProductDAO;
import com.chainsys.supermarketapp.daofactory.DAOFactory;
import com.chainsys.supermarketapp.exception.DbException;
import com.chainsys.supermarketapp.exception.ServiceConstant;
import com.chainsys.supermarketapp.exception.ServiceException;
import com.chainsys.supermarketapp.model.Product;

public class ProductService {
	ProductDAO pd=DAOFactory.getProductDAO();
	
	public int save(Product product) throws ServiceException
	{
		try {
			return pd.save(product);
		} catch (DbException e) {
			throw new ServiceException(ServiceConstant.INVALID_SAVE);
		}
		
	}
	
	public int delete(Product product) throws ServiceException
	{
		try {
			return pd.delete(product);
		} catch (DbException e) {
			throw new ServiceException(ServiceConstant.INVALID_DELETE);
		}
		
	}
	
	public int deleteproductAll(Product product) throws ServiceException
	{
		try {
			return pd.deleteproductAll(product);
		} catch (DbException e) {
			throw new ServiceException(ServiceConstant.INVALID_DELETE);
		
		}
		
	}

	public int update(Product product) throws ServiceException
	{
		try {
			return pd.update(product);
		} catch (DbException e) {
			throw new ServiceException(ServiceConstant.INVALID_UPDATE);
		}
		
	}
	
	public List<Product> findAll()throws ServiceException
	{
		try {
			return pd.findAll();
		} catch (DbException e) {
			throw new ServiceException(ServiceConstant.INVALID_FIND);
		}
		
	}
}
