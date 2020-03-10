package com.chainsys.supermarketapp.validator;

import com.chainsys.supermarketapp.dao.ProductDAO;
import com.chainsys.supermarketapp.dao.ProductStockDAO;
import com.chainsys.supermarketapp.daofactory.DAOFactory;
import com.chainsys.supermarketapp.exception.DbException;
import com.chainsys.supermarketapp.exception.ValidationException;

public class ProductValidation {

	public boolean isProductNameExists(String productName) throws DbException, ValidationException {
		ProductDAO p = DAOFactory.getProductDAO();

		return p.isProductNameExists(productName);
	}

	public boolean isProductExists(int productno) throws DbException, ValidationException {
		ProductStockDAO product = DAOFactory.getProductStockDAO();

		return product.isProductExists(productno);
	}
}
