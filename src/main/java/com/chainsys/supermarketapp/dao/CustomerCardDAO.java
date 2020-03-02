package com.chainsys.supermarketapp.dao;

import org.springframework.stereotype.Repository;

import com.chainsys.supermarketapp.exception.DbException;
import com.chainsys.supermarketapp.model.CustomerCard;
@Repository
public interface CustomerCardDAO
{
public void addCustomerCard(CustomerCard customercard) throws DbException;
public void deleteCustomerCard(CustomerCard customercard)throws DbException;
public void displayCustomerCard(CustomerCard customercard)throws DbException;
public void updateCustomerCard(CustomerCard customercard)throws DbException;

}
