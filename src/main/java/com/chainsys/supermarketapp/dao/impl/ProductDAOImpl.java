package com.chainsys.supermarketapp.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.chainsys.supermarketapp.dao.ProductDAO;
import com.chainsys.supermarketapp.exception.DbException;
import com.chainsys.supermarketapp.exception.ErrorConstants;
import com.chainsys.supermarketapp.model.Product;
import com.chainsys.supermarketapp.utill.ConnectionUtil;

public class ProductDAOImpl implements ProductDAO {
	private static final Logger logger = LoggerFactory.getLogger(ProductDAOImpl.class);
	private static final boolean NULL = false;

	@Override
	public int save(Product product) throws DbException {
		String sql = "insert into product (product_id,product_name,price) values(pro_id.nextval,?,?)";
		int rows = 0;
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
			logger.debug(sql);
			ps.setString(1, product.getProductname());
			ps.setInt(2, product.getPrice());
			rows = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DbException(ErrorConstants.INVALID_ADD);
		}
		return rows;
	}

	@Override
	public int delete(Product product) throws DbException {
		String sql = "Delete from product where product_name=?";
		int rows = 0;
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
			ps.setString(1, product.getProductname());
			rows = ps.executeUpdate();
		} catch (SQLException e) {
			throw new DbException(ErrorConstants.INVALID_DELETE);
		}
		return rows;
	}

	@Override
	public List<Product> findAll() throws DbException {
		String sql = "select product_id,product_name,price,active from product";
		List<Product> list = new ArrayList<>();
		try (Connection con = ConnectionUtil.getConnection();
				Statement st1 = con.createStatement();
				ResultSet rs = st1.executeQuery(sql);) {
			while (rs.next() != NULL) {
				Product p = new Product();
				p.setProductname(rs.getString("product_name"));
				p.setPrice(rs.getInt("price"));
				p.setPid(rs.getInt("product_id"));
				p.setActive(rs.getInt("active"));
				list.add(p);
			}
		} catch (Exception e) {
			throw new DbException(ErrorConstants.INVALID_SELECT);
		}
		return (list);
	}


	@Override
	public int update(Product product) throws DbException {
		String sql = "update product set price= ? where product_name= ?  ";
		int rows = 0;
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
			ps.setString(2, product.getProductname());
			ps.setInt(1, product.getPrice());
			rows = ps.executeUpdate();
		} catch (Exception e) {
			throw new DbException(ErrorConstants.INVALID_UPDATE);
		}
		return rows;
	}



	@Override
	public int deleteproductAll(Product product) throws DbException {
		int rows = 0;
		try (Connection con = ConnectionUtil.getConnection();
				CallableStatement stmt = con.prepareCall("{call delete_product(?)}");) {

			stmt.setInt(1, product.getPid());
			rows = stmt.executeUpdate();
		} catch (SQLException e) {
			throw new DbException(ErrorConstants.INVALID_DELETE);
		}
		return rows;

	}
	public List<Product> findOneProductAvailable() throws DbException {
		String sql = "select * FROM product p where active =1 and product_id in ( select  product_no from product_stock pk where pk.product_no=p.product_id and pk.quantity > 0)";
		List<Product> list = new ArrayList<>();
		try (Connection con = ConnectionUtil.getConnection(); Statement st1 = con.createStatement()) {
			try (ResultSet rs = st1.executeQuery(sql);) {
				while (rs.next() != NULL) {
					Product p = new Product();
					p.setProductname(rs.getString("product_name"));
					p.setPrice(rs.getInt("price"));
					p.setPid(rs.getInt("product_id"));
					list.add(p);
				}
			}
		} catch (Exception e) {
			throw new DbException(ErrorConstants.INVALID_SELECT);
		}
		return (list);
	}
	
	public int findOneProductPrice(int productId) throws DbException {
		String sql = "select price from product where product_id=? ";
		int price = 0;
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
			ps.setInt(1, productId);
			try (ResultSet rs = ps.executeQuery();) {
				while (rs.next()) {
					price = rs.getInt("price");
				}
			} 
		} catch (Exception e) {
			throw new DbException(ErrorConstants.INVALID_SELECT);
		}
		return (price);
	}

	@Override
	public boolean isProductNameExists(String productName) throws DbException {
		boolean exists = false;
		String sql1 = "select product_name from product where product_name=?";
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement pst = con.prepareStatement(sql1);) {
			pst.setString(1,productName );
			try (ResultSet rs = pst.executeQuery();) {
				if (rs.next()) {
					exists = true;
				}
			} 
		} catch (Exception e) {

			throw new DbException(ErrorConstants.INVALID_SELECT);
		}
		return exists;
	}



	
}