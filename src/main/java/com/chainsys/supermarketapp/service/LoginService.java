package com.chainsys.supermarketapp.service;

import com.chainsys.supermarketapp.dao.LoginDAO;
import com.chainsys.supermarketapp.daofactory.DAOFactory;
import com.chainsys.supermarketapp.exception.DbException;
import com.chainsys.supermarketapp.exception.ServiceConstant;
import com.chainsys.supermarketapp.exception.ServiceException;
import com.chainsys.supermarketapp.model.Login;

public class LoginService {
	LoginDAO log = DAOFactory.getLoginDAO();

	public int save(Login login) throws ServiceException {
		try {
			return log.save(login);
		} catch (DbException e) {
			throw new ServiceException(ServiceConstant.INVALID_SAVE);
		}

	}

	public Login findByUsernameAndPassword(Login login) throws ServiceException {
		try {
			return log.findByUsernameAndPassword(login);
		} catch (DbException e) {
			throw new ServiceException(ServiceConstant.INVALID_FIND);
		}

	}
}
