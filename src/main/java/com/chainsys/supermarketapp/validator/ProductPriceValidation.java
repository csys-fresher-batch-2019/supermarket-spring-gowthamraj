package com.chainsys.supermarketapp.validator;

import com.chainsys.supermarketapp.dao.ProductDAO;
import com.chainsys.supermarketapp.daofactory.DAOFactory;
import com.chainsys.supermarketapp.exception.DbException;
import com.chainsys.supermarketapp.exception.ValidationException;

public class ProductPriceValidation {
	
	public int findOneProductPrice(int productId) throws DbException, ValidationException
	{
		ProductDAO pro=DAOFactory.getProductDAO();
		return pro.findOneProductPrice(productId);
		
	}

}
