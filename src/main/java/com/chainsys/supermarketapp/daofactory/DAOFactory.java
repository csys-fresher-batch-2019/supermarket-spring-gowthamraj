package com.chainsys.supermarketapp.daofactory;

import org.springframework.stereotype.Repository;

import com.chainsys.supermarketapp.dao.BillOrderDAO;
import com.chainsys.supermarketapp.dao.CustomerCardDAO;
import com.chainsys.supermarketapp.dao.EmployeeDAO;
import com.chainsys.supermarketapp.dao.LoginDAO;
import com.chainsys.supermarketapp.dao.ProductDAO;
import com.chainsys.supermarketapp.dao.ProductStockDAO;
import com.chainsys.supermarketapp.dao.impl.BillOrderImple;
import com.chainsys.supermarketapp.dao.impl.CustomerCardImpl;
import com.chainsys.supermarketapp.dao.impl.EmployeeImpl;
import com.chainsys.supermarketapp.dao.impl.LoginImple;
import com.chainsys.supermarketapp.dao.impl.ProductImple;
import com.chainsys.supermarketapp.dao.impl.ProductStockImple;

@Repository
public class DAOFactory {

	public static LoginDAO getLoginDAO()
	{
		return new LoginImple();
		
	}
	public static ProductDAO getProductDAO()
	{
		return new ProductImple();
		
	}
	public static ProductStockDAO getProductStockDAO()
	{
		return new ProductStockImple();
		
	}
	public static EmployeeDAO getEmployeeDAO()
	{
		return new EmployeeImpl();
		
	}
	public static CustomerCardDAO getCustomerCardDAO()
	{
		return new CustomerCardImpl();
		
	}
	public static BillOrderDAO getBillOrderDAO()
	{
		return new BillOrderImple();
	}
	
}
