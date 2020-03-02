package com.chainsys.supermarketapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.chainsys.supermarketapp.dao.CustomerCardDAO;
import com.chainsys.supermarketapp.exception.DbException;
import com.chainsys.supermarketapp.exception.ErrorConstants;
import com.chainsys.supermarketapp.model.CustomerCard;

public class CustomerCardImpl implements CustomerCardDAO {
	private static final Logger logger = LoggerFactory.getLogger(CustomerCardImpl.class);

	@Override
	public int addCustomerCard(CustomerCard customercard) throws DbException {

		String sql = "insert into customer_card (customer_name,mobile_number,address) values(?,?,?)";
		int rows = 0;
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setString(1, customercard.getCustomername());
			pst.setLong(2, customercard.getContactnumber());
			pst.setString(3, customercard.getAddress());
			rows = pst.executeUpdate();
		} catch (Exception e) {
			throw new DbException(ErrorConstants.INVALID_ADD);
		}
		return rows;
	}

	@Override
	public int deleteCustomerCard(CustomerCard customercard) throws DbException {

		String sql = "delete from customer_card where customer_name=?";
		int rows = 0;
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setString(1, customercard.getCustomername());
			rows = pst.executeUpdate();
		} catch (Exception e) {
			throw new DbException(ErrorConstants.INVALID_DELETE);
		}
		return rows;
	}

	@Override
	public void displayCustomerCard(CustomerCard customercard) throws DbException {

		String sql = "select customer_name,mobile_number,address from customer_card";
		try (Connection con = ConnectionUtil.getConnection();
				Statement st1 = con.createStatement();
				ResultSet rs = st1.executeQuery(sql);) {
			while (rs.next()) {

				String name = rs.getString("customer_name");
				long contact = rs.getLong("mobile_number");
				String address = rs.getString("address");

				logger.debug("customer name = " + name + "\t contact = " + contact + "\t Address =" + address);
			}
		} catch (Exception e) {
			throw new DbException(ErrorConstants.INVALID_SELECT);
		}
	}

	@Override
	public int updateCustomerCard(CustomerCard customercard) throws DbException {
		String sql = "update customer_card set address=? where customer_name=?";
		int rows = 0;
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setString(1, customercard.getAddress());
			pst.setString(2, customercard.getCustomername());
			rows = pst.executeUpdate();
		} catch (SQLException e) {
			throw new DbException(ErrorConstants.INVALID_UPDATE);
		}
		return rows;
	}

}
