package com.chainsys.supermarketapp.utill;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.TimeZone;

import org.springframework.stereotype.Component;

import com.chainsys.supermarketapp.exception.DbException;
import com.chainsys.supermarketapp.exception.ErrorConstants;

@Component
public class ConnectionUtil {
		public static Connection getConnection() throws DbException {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			throw new DbException(ErrorConstants.INVALID_CON);
		}
		Connection con;
		try {
			TimeZone.setDefault(TimeZone.getTimeZone("Asia/Kolkata"));
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","oracle");
			//con = DriverManager.getConnection("jdbc:oracle:thin:@13.235.147.120:1521:XE", "gowtham", "gowtham");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DbException(ErrorConstants.INVALID_CON);
		}
		return con;
	}
}
