package com.chainsys.supermarketapp.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.chainsys.supermarketapp.exception.DbException;
import com.chainsys.supermarketapp.model.Product;
@Repository
public interface ProductDAO {
	
	int save(Product product) throws DbException;
	int delete(Product product) throws DbException;
	List<Product> findAll()throws DbException;
	int update(Product product) throws DbException;
	int deleteproductAll(Product product) throws DbException;
}
