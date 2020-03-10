package com.chainsys.supermarketapp.service;

import com.chainsys.supermarketapp.dao.LoginDAO;
import com.chainsys.supermarketapp.daofactory.DAOFactory;
import com.chainsys.supermarketapp.exception.DbException;
import com.chainsys.supermarketapp.exception.ServiceConstant;
import com.chainsys.supermarketapp.exception.ServiceException;
import com.chainsys.supermarketapp.exception.ValidationException;
import com.chainsys.supermarketapp.model.Login;
import com.chainsys.supermarketapp.validator.Validator;

public class LoginService {
	
public static LoginDAO log = DAOFactory.getLoginDAO();
	public static int save(Login login) throws ServiceException, ValidationException {
		
		try {
			Validator.validateLoginForm(login);
			return log.save(login);
			
		} catch (DbException e) {
			throw new ServiceException(ServiceConstant.INVALID_SAVE);
		}
		 
		 
	}

	public Login findByUsernameAndPassword(Login login) throws ServiceException, ValidationException {
		
		try {
			Validator.validateLoginForm(login);
			return log.findByUsernameAndPassword(login);
		} catch (DbException e) {
			throw new ServiceException(ServiceConstant.INVALID_FIND);
		}

	}
}
