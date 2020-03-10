package com.chainsys.supermarketapp.validator;

import com.chainsys.supermarketapp.dao.ProductStockDAO;
import com.chainsys.supermarketapp.daofactory.DAOFactory;
import com.chainsys.supermarketapp.exception.DbException;
import com.chainsys.supermarketapp.exception.ValidationException;
import com.chainsys.supermarketapp.model.Order;

public class ProductQuantityValidation {
	
	public boolean productQuantityValidate(Order billorder) throws DbException,ValidationException
	{
		ProductStockDAO ps=DAOFactory.getProductStockDAO();
		return ps.productQuantityValidate(billorder);
	}


}
