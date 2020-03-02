package com.chainsys.supermarketapp.dao;

import org.springframework.stereotype.Repository;

import com.chainsys.supermarketapp.exception.DbException;
import com.chainsys.supermarketapp.model.OrderItem;
@Repository
public interface BillsDAO {
	public void addBills(OrderItem bills) throws DbException;
	public void deleteBills(OrderItem bills)throws DbException;
	public void displayBills(OrderItem bills)throws DbException;
	public void updateBills(OrderItem bills)throws DbException;
	
}
