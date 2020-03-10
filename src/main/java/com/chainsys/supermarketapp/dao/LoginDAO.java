package com.chainsys.supermarketapp.dao;

import org.springframework.stereotype.Repository;

import com.chainsys.supermarketapp.exception.DbException;
import com.chainsys.supermarketapp.model.Login;

@Repository
public interface LoginDAO {

	int save(Login login) throws DbException;

	public Login findByUsernameAndPassword(Login login) throws DbException;

	public boolean isUsernameExists(String username) throws DbException;
}
