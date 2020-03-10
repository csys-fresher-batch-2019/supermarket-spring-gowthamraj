package com.chainsys.supermarketapp.dao;

import java.time.LocalDate;
import org.springframework.stereotype.Repository;
import com.chainsys.supermarketapp.exception.DbException;
import com.chainsys.supermarketapp.model.OrderItem;

@Repository
public interface CaseDAO {
	public int countEmployee() throws DbException;

	public int findByTotalIncome(OrderItem bills) throws DbException;

	public int findByTodayIncome(LocalDate date) throws DbException;

	
}
