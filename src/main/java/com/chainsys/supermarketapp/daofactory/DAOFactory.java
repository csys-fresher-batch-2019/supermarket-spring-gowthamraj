package com.chainsys.supermarketapp.daofactory;

import org.springframework.stereotype.Repository;

import com.chainsys.supermarketapp.dao.BillOrderDAO;
import com.chainsys.supermarketapp.dao.CaseDAO;
import com.chainsys.supermarketapp.dao.CustomerCardDAO;
import com.chainsys.supermarketapp.dao.EmployeeDAO;
import com.chainsys.supermarketapp.dao.LoginDAO;
import com.chainsys.supermarketapp.dao.ProductDAO;
import com.chainsys.supermarketapp.dao.ProductStockDAO;
import com.chainsys.supermarketapp.dao.impl.BillOrderDAOImpl;
import com.chainsys.supermarketapp.dao.impl.CaseDAOImpl;
import com.chainsys.supermarketapp.dao.impl.CustomerCardDAOImpl;
import com.chainsys.supermarketapp.dao.impl.EmployeeDAOImpl;
import com.chainsys.supermarketapp.dao.impl.LoginDAOImpl;
import com.chainsys.supermarketapp.dao.impl.ProductDAOImpl;
import com.chainsys.supermarketapp.dao.impl.ProductStockDAOImpl;

@Repository
public class DAOFactory {
	
	public static CaseDAO getCaseDAO()
	{
		return new CaseDAOImpl();
		
	}

	public static LoginDAO getLoginDAO()
	{
		return new LoginDAOImpl();
		
	}
	public static ProductDAO getProductDAO()
	{
		return new ProductDAOImpl();
		
	}
	public static ProductStockDAO getProductStockDAO()
	{
		return new ProductStockDAOImpl();
		
	}
	public static EmployeeDAO getEmployeeDAO()
	{
		return new EmployeeDAOImpl();
		
	}
	public static CustomerCardDAO getCustomerCardDAO()
	{
		return new CustomerCardDAOImpl();
		
	}
	public static BillOrderDAO getBillOrderDAO()
	{
		return new BillOrderDAOImpl();
	}
	
}
