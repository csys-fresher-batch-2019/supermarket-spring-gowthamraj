package com.chainsys.supermarketapp.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.chainsys.supermarketapp.exception.DbException;
import com.chainsys.supermarketapp.model.Employee;
@Repository
public interface EmployeeDAO {
	void addEmployeeDetils(Employee employee) throws DbException;
	void deleteEmployeeDetils(Employee employee) throws DbException;
	void updateEmployeeDetils(Employee employee) throws DbException;
	List<Employee> displayEmployeeDetils() throws DbException;

}
