package com.chainsys.supermarketapp.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.chainsys.supermarketapp.exception.DbException;
import com.chainsys.supermarketapp.model.Employee;
@Repository
public interface EmployeeDAO {
	int save(Employee employee) throws DbException;
	int delete(Employee employee) throws DbException;
	int update(Employee employee) throws DbException;
	List<Employee> findAll() throws DbException;

}
