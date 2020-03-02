package com.chainsys.supermarketapp.dao;

import org.springframework.stereotype.Repository;

import com.chainsys.supermarketapp.exception.DbException;
import com.chainsys.supermarketapp.model.Login;
@Repository
public interface LoginDAO {
	
	void add(Login login) throws DbException;
	public Login check(Login login) throws DbException;
}
