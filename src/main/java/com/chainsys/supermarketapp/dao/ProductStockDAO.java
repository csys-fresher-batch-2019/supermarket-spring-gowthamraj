package com.chainsys.supermarketapp.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.chainsys.supermarketapp.exception.DbException;
import com.chainsys.supermarketapp.model.ProductStock;
@Repository
public interface ProductStockDAO {
	int addProductStock(ProductStock productstock )throws DbException;
	int deleteProductStock(ProductStock productstock )throws DbException;
	int updateProductStock(ProductStock productstock )throws DbException;

	List<ProductStock> displayProductStock() throws DbException;
	int updateProductStock1(ProductStock productstock) throws DbException;



}
