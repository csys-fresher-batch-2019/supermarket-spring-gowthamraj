package com.chainsys.supermarketapp.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.chainsys.supermarketapp.exception.DbException;
import com.chainsys.supermarketapp.model.Order;
import com.chainsys.supermarketapp.model.OrderItem;

@Repository
public interface BillOrderDAO {
	int save(Order billorder) throws DbException;

	List<Order> findAll() throws DbException;

	int update(Order billorder) throws DbException;

	int delete(Order billorder) throws DbException;

	int update(int cusno) throws DbException;

	public List<OrderItem> findAllBillItems(int billNo) throws DbException;

}
