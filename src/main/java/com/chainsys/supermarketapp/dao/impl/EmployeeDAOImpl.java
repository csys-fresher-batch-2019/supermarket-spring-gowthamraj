package com.chainsys.supermarketapp.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.chainsys.supermarketapp.dao.EmployeeDAO;
import com.chainsys.supermarketapp.exception.DbException;
import com.chainsys.supermarketapp.exception.ErrorConstants;
import com.chainsys.supermarketapp.model.Employee;
import com.chainsys.supermarketapp.utill.ConnectionUtil;

public class EmployeeDAOImpl implements EmployeeDAO {

	@Override
	public int save(Employee employee) throws DbException {
		String sql = "insert into employee(employee_id,employee_name,dob,doj,address) values( emp_idd.nextval,?,?,?,?)";
		int rows = 0;
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setString(1, employee.getEmployeename());
			pst.setDate(2, Date.valueOf(employee.getDob()));
			pst.setDate(3, Date.valueOf(employee.getDoj()));
			pst.setString(4, employee.getAddress());
			rows = pst.executeUpdate();
		} catch (SQLException e) {
			throw new DbException(ErrorConstants.INVALID_ADD, e);
		}
		return rows;

	}

	@Override
	public List<Employee> findAll() throws DbException {
		String sql = "select employee_id,employee_name,dob,doj,address from employee";
		List<Employee> list = new ArrayList<>();
		try (Connection con = ConnectionUtil.getConnection();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);) {
			while (rs.next()) {
				Employee e = new Employee();
				e.setEmployeeid(rs.getInt("employee_id"));
				e.setEmployeename(rs.getString("employee_name"));
				Date ar = rs.getDate("dob");
				LocalDate pa1 = ar.toLocalDate();
				e.setDob(pa1);
				Date ar1 = rs.getDate("doj");
				LocalDate ex = ar1.toLocalDate();
				e.setDoj(ex);

				e.setAddress(rs.getString("address"));
				list.add(e);
			}
		} catch (SQLException e) {
			throw new DbException(ErrorConstants.INVALID_SELECT, e);
		}
		return list;
	}

	@Override
	public int delete(Employee employee) throws DbException {
		String ins = "delete from employee where employee_name=?";
		int rows = 0;
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement pst = con.prepareStatement(ins);) {
			pst.setString(1, employee.getEmployeename());
			rows = pst.executeUpdate();
		} catch (SQLException e) {
			throw new DbException(ErrorConstants.INVALID_DELETE, e);
		}
		return rows;
	}

	@Override
	public int update(Employee employee) throws DbException {

		String sql = "update employee set address=? where  employee_name=?";
		int rows = 0;
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setString(2, employee.getEmployeename());
			pst.setString(1, employee.getAddress());
			rows = pst.executeUpdate();
		} catch (SQLException e) {
			throw new DbException(ErrorConstants.INVALID_UPDATE, e);
		}
		return rows;
	}
}
