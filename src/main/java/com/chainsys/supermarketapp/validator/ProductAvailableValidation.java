package com.chainsys.supermarketapp.validator;

import java.util.List;

import com.chainsys.supermarketapp.dao.ProductDAO;
import com.chainsys.supermarketapp.daofactory.DAOFactory;
import com.chainsys.supermarketapp.exception.DbException;
import com.chainsys.supermarketapp.exception.ValidationException;
import com.chainsys.supermarketapp.model.Product;

public class ProductAvailableValidation {
	
	public List<Product> findOneProductAvailable() throws DbException, ValidationException 
	{
		ProductDAO pro=DAOFactory.getProductDAO();
		return pro.findOneProductAvailable();
	}

}
