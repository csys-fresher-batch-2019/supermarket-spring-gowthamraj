package com.chainsys.supermarketapp.validator;

import com.chainsys.supermarketapp.dao.LoginDAO;
import com.chainsys.supermarketapp.daofactory.DAOFactory;
import com.chainsys.supermarketapp.exception.DbException;
import com.chainsys.supermarketapp.exception.ValidationException;

public class UserValidation {

	public boolean isUsernameExists(String username) throws DbException, ValidationException {
		if (username == null || "".equals(username.trim())) {
			throw new ValidationException("Username cannot be empty/blank");
		}
		LoginDAO loginDAO = DAOFactory.getLoginDAO();
		return loginDAO.isUsernameExists(username);

	}

}
