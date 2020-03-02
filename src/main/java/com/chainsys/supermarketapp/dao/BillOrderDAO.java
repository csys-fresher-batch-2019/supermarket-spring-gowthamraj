package com.chainsys.supermarketapp.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.chainsys.supermarketapp.exception.DbException;
import com.chainsys.supermarketapp.model.Order;
import com.chainsys.supermarketapp.model.OrderItem;
@Repository
public interface BillOrderDAO {
	int addBillOrder(Order billorder)throws DbException;
	 List<Order>displayBillOrder() throws DbException;
	void updateBillOrder(Order billorder)throws DbException;
	void deleteBillOrder(Order billorder)throws DbException;
	void updateBillStatus(int cusno) throws DbException;
	public List<OrderItem> viewBillItems(int billNo) throws DbException;

}
