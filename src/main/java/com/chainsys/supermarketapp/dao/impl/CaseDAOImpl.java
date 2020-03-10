package com.chainsys.supermarketapp.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.chainsys.supermarketapp.dao.CaseDAO;
import com.chainsys.supermarketapp.exception.DbException;
import com.chainsys.supermarketapp.exception.ErrorConstants;
import com.chainsys.supermarketapp.model.OrderItem;
import com.chainsys.supermarketapp.utill.ConnectionUtil;

public class CaseDAOImpl implements CaseDAO {
	private static final Logger logger = LoggerFactory.getLogger(CaseDAOImpl.class);

	@Override
	public int countEmployee() throws DbException {
		String sql = "select count(*)  as employee_count from employee";
		int employeeCount = 0;
		try (Connection con = ConnectionUtil.getConnection();
				Statement st1 = con.createStatement();
				ResultSet rs = st1.executeQuery(sql);) {
			if (rs.next()) {
				employeeCount = rs.getInt("employee_count");
				logger.debug("Total number of employee in the market  =" + employeeCount);

			}
		} catch (SQLException e) {
			throw new DbException(ErrorConstants.INVALID_SELECT,e);
		}
		return employeeCount;

	}

	@Override
	public int findByTodayIncome(LocalDate date) throws DbException {
		String sql = "select GET_TOTAL_AMOUNT(?) as total_amount from dual ";
		int amount = 0;
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement st = con.prepareStatement(sql);) {
			st.setDate(1, Date.valueOf(date));
			try (ResultSet rs = st.executeQuery();) {
				if (rs.next()) {
					amount = rs.getInt("total_amount");
				}
			}
		} catch (SQLException e) {
			throw new DbException(ErrorConstants.INVALID_SELECT,e);
		}
		return amount;
	}

	@Override
	public int findByTotalIncome(OrderItem bills) throws DbException {
		String sql = "select sum(total_amount)as daily_income from bill_order where status='paid'";
		int total = 0;
		try (Connection con = ConnectionUtil.getConnection();
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql);) {
			while (rs.next()) {
				total = rs.getInt("daily_income");
			}
		} catch (SQLException e) {

			throw new DbException(ErrorConstants.INVALID_SELECT,e);
		}
		return total;
	}

}
