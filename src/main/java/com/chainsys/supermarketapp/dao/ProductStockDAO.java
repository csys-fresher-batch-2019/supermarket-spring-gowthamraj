package com.chainsys.supermarketapp.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.chainsys.supermarketapp.exception.DbException;
import com.chainsys.supermarketapp.model.Order;
import com.chainsys.supermarketapp.model.ProductStock;

@Repository
public interface ProductStockDAO {
	int save(ProductStock productstock) throws DbException;

	int delete(ProductStock productstock) throws DbException;

	int update(ProductStock productstock) throws DbException;

	List<ProductStock> findAll() throws DbException;

	int updateProductStockquantity(ProductStock productstock) throws DbException;

	public boolean isProductExists(int productno) throws DbException;

	public boolean productQuantity(Order billorder) throws DbException;

	public boolean getStockProductNo(int productNo) throws DbException;

}
