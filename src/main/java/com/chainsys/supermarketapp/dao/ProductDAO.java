package com.chainsys.supermarketapp.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.chainsys.supermarketapp.exception.DbException;
import com.chainsys.supermarketapp.model.Product;
@Repository
public interface ProductDAO {
	
	int addproductDetails(Product product) throws DbException;
	int deleteproductDetails(Product product) throws DbException;
	List<Product> displayproduct()throws DbException;
	int updateproduct(Product product) throws DbException;
	int getProductPrice(int productId) throws DbException;
	List<Product> displayproductAvailable() throws DbException;
	int deleteproductAll(Product product) throws DbException;
}
