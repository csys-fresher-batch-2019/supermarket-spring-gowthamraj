package com.chainsys.supermarketapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.chainsys.supermarketapp.dao.LoginDAO;
import com.chainsys.supermarketapp.exception.DbException;
import com.chainsys.supermarketapp.exception.ErrorConstants;
import com.chainsys.supermarketapp.model.Login;
import com.chainsys.supermarketapp.utill.ConnectionUtil;

public class LoginDAOImpl implements LoginDAO {
	private static final Logger logger = LoggerFactory.getLogger(LoginDAOImpl.class);

	public Login findByUsernameAndPassword(Login login) throws DbException {
		String sql = "select user_name,passwords from login where user_name = ? and passwords = ?";
		Login log1=null;
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
			ps.setString(1, login.getUserName());
			ps.setString(2, login.getPassword());
			try (ResultSet rs1 = ps.executeQuery();) {
				
				if (rs1.next()) {
					log1=new Login();
					log1.setUserName(rs1.getString("user_name"));
					log1.setPassword(rs1.getString("passwords"));
				}
			}
		} catch (SQLException e) {

			throw new DbException(ErrorConstants.INVALID_SELECT,e);
		}
		return log1;
	}

	public boolean isUsernameExists(String username) throws DbException {
		boolean exists = false;
		String sql1 = "select user_name from login where user_name=?";
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement pst = con.prepareStatement(sql1);) {
			pst.setString(1, username);
			try (ResultSet rs = pst.executeQuery();) {
				if (rs.next()) {
					exists = true;
				}
			}
		} catch (SQLException e) {

			throw new DbException(ErrorConstants.INVALID_SELECT,e);
		}
		return exists;
	}
 	@Override
	public int save(Login login) throws DbException {
		String sql = "insert into login (user_name,passwords) values(?,?)";
		logger.debug(sql);
		int rows = 0;
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
			ps.setString(1, login.getUserName());
			ps.setString(2, login.getPassword());
			rows = ps.executeUpdate();

		} catch (SQLException e) {

			throw new DbException(ErrorConstants.INVALID_ADD,e);
		}
		return rows;
	}

}
