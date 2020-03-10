package com.chainsys.supermarketapp.service;

import java.util.List;
import com.chainsys.supermarketapp.dao.ProductDAO;
import com.chainsys.supermarketapp.daofactory.DAOFactory;
import com.chainsys.supermarketapp.exception.DbException;
import com.chainsys.supermarketapp.exception.ServiceConstant;
import com.chainsys.supermarketapp.exception.ServiceException;
import com.chainsys.supermarketapp.exception.ValidationException;
import com.chainsys.supermarketapp.model.Product;
import com.chainsys.supermarketapp.validator.ProductValidation;
import com.chainsys.supermarketapp.validator.Validator;

public class ProductService {
	public static ProductDAO pd = DAOFactory.getProductDAO();

	public static ProductValidation productValidation = new ProductValidation();

	public static int save(Product product) throws ServiceException, ValidationException {
		try {
			Validator.validateProductForm(product);
			boolean exists = productValidation.isProductNameExists(product.getProductName());
			if (exists) {
				throw new ValidationException("Product name already exists");
			}
			return pd.save(product);
		} catch (DbException e) {
			throw new ServiceException(ServiceConstant.INVALID_SAVE);
		}

	}

	public int delete(Product product) throws ServiceException, ValidationException {
		try {
			Validator.validateProductForm(product);
			return pd.delete(product);
		} catch (DbException e) {
			throw new ServiceException(ServiceConstant.INVALID_DELETE);
		}

	}

	public int deleteproductAll(Product product) throws ServiceException, ValidationException {
		try {
			Validator.validateProductForm(product);
			return pd.deleteproductAll(product);
		} catch (DbException e) {
			throw new ServiceException(ServiceConstant.INVALID_DELETE);

		}

	}

	public int update(Product product) throws ServiceException, ValidationException {
		try {
			Validator.validateProductForm(product);
			return pd.update(product);
		} catch (DbException e) {
			throw new ServiceException(ServiceConstant.INVALID_UPDATE);
		}

	}

	public List<Product> findAll() throws ServiceException {
		try {
			return pd.findAll();
		} catch (DbException e) {
			throw new ServiceException(ServiceConstant.INVALID_FIND);
		}

	}
}
