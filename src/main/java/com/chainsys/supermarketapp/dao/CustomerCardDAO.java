package com.chainsys.supermarketapp.dao;

import org.springframework.stereotype.Repository;

import com.chainsys.supermarketapp.exception.DbException;
import com.chainsys.supermarketapp.model.CustomerCard;

@Repository
public interface CustomerCardDAO {
	public int save(CustomerCard customercard) throws DbException;

	public int delete(CustomerCard customercard) throws DbException;

	public void findAll(CustomerCard customercard) throws DbException;

	public int update(CustomerCard customercard) throws DbException;

}
