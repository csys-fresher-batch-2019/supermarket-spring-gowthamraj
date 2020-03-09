package com.chainsys.supermarketapp.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.chainsys.supermarketapp.exception.DbException;
import com.chainsys.supermarketapp.model.OrderItem;
import com.chainsys.supermarketapp.model.Product;
@Repository
public interface CaseDAO {
	public int countEmployee() throws DbException;
	public int findByTotalIncome(OrderItem bills)throws DbException;
	public int findByTodayIncome(LocalDate date)throws DbException;
	public List<Product> findByPrice(int min, int max) throws DbException;
	public List<OrderItem> countCustomer(OrderItem bills) throws DbException;
	
}
