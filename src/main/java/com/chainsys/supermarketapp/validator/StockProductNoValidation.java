package com.chainsys.supermarketapp.validator;

import com.chainsys.supermarketapp.dao.ProductStockDAO;
import com.chainsys.supermarketapp.daofactory.DAOFactory;
import com.chainsys.supermarketapp.exception.DbException;
import com.chainsys.supermarketapp.exception.ValidationException;

public class StockProductNoValidation {

	public boolean getStockProductNo(int productNo) throws DbException, ValidationException {
		ProductStockDAO pss = DAOFactory.getProductStockDAO();
		return pss.getStockProductNo(productNo);
	}

}
