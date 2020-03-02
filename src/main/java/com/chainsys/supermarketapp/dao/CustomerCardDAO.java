package com.chainsys.supermarketapp.dao;

import org.springframework.stereotype.Repository;

import com.chainsys.supermarketapp.exception.DbException;
import com.chainsys.supermarketapp.model.CustomerCard;
@Repository
public interface CustomerCardDAO
{
public int addCustomerCard(CustomerCard customercard) throws DbException;
public int deleteCustomerCard(CustomerCard customercard)throws DbException;
public void displayCustomerCard(CustomerCard customercard)throws DbException;
public int updateCustomerCard(CustomerCard customercard)throws DbException;

}
