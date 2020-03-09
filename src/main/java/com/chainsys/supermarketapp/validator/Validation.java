package com.chainsys.supermarketapp.validator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.chainsys.supermarketapp.exception.DbException;
import com.chainsys.supermarketapp.exception.ErrorConstants;
import com.chainsys.supermarketapp.exception.ValidationException;
import com.chainsys.supermarketapp.model.Order;
import com.chainsys.supermarketapp.model.OrderItem;
import com.chainsys.supermarketapp.model.Product;
import com.chainsys.supermarketapp.utill.ConnectionUtil;

public class Validation {

	private static final boolean NULL = false;

	public boolean isProductExists(int productno) throws DbException, ValidationException {
		boolean exists = false;
		String sql1 = "select product_no from product_stock where product_no=?";
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement pst = con.prepareStatement(sql1);) {
			pst.setInt(1, productno);
			try (ResultSet rs = pst.executeQuery();) {
				if (rs.next()) {
					exists = true;
				}
			} catch (Exception v) {
				throw new ValidationException("Product not available");
			}
		} catch (Exception e) {

			throw new DbException(ErrorConstants.INVALID_SELECT);
		}
		return exists;
	}

	public boolean isUsernameExists(String username) throws DbException, ValidationException {
		boolean exists = false;
		String sql1 = "select user_name from login where user_name=?";
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement pst = con.prepareStatement(sql1);) {
			pst.setString(1, username);
			try (ResultSet rs = pst.executeQuery();) {
				if (rs.next()) {
					exists = true;
				}
			} catch (Exception v) {
				throw new ValidationException("Username available");
			}
		} catch (Exception e) {

			throw new DbException(ErrorConstants.INVALID_SELECT);
		}
		return exists;
	}

	public List<Product> findOneProductAvailable() throws DbException, ValidationException {
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
			}catch (Exception v) {
				throw new ValidationException("Issue in get product price");
			}
		} catch (Exception e) {
			throw new DbException(ErrorConstants.INVALID_SELECT);
		}
		return (list);
	}

	public int findOneProductPrice(int productId) throws DbException, ValidationException {
		String sql = "select price from product where product_id=? ";
		int price = 0;
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
			ps.setInt(1, productId);
			try (ResultSet rs = ps.executeQuery();) {
				while (rs.next()) {
					price = rs.getInt("price");
				}
			}catch (Exception v) {
				throw new ValidationException("Product Price not available");
			}
		} catch (Exception e) {
			throw new DbException(ErrorConstants.INVALID_SELECT);
		}
		return (price);
	}

	public boolean getStockProductNo(int productNo) throws DbException, ValidationException {
		boolean exists = false;
		// String sql="select product_id FROM product p where product_id in ( select
		// product_no from product_stock pk where pk.product_no=?)";
		String sql = "select  product_no from product_stock pk where pk.product_no=?";

		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
			try (ResultSet rs = ps.executeQuery();) {
				if (rs.next()) {
					exists = true;
				}
			}catch (Exception v) {
				throw new ValidationException("Issue of getting product no");
			}
		} catch (Exception e) {
			throw new DbException(ErrorConstants.INVALID_DELETE);
		}
		return exists;
	}

	public boolean productQuantityValidate(Order billorder) throws DbException, ValidationException {
		boolean stockavailable = true;
		List<OrderItem> items = billorder.getItems();
		for (OrderItem orderItem : items) {
			String sql = "select quantity from product_stock where product_no=?";
			try (Connection con = ConnectionUtil.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
				pst.setInt(1, orderItem.getProductId());

				pst.executeQuery();
				try (ResultSet rs = pst.executeQuery();) {
					if (rs.next()) {
						int a = rs.getInt("quantity");
						if (orderItem.getQuantity() > a) {
							stockavailable = false;
						}
					}
				}catch (Exception v) {
					throw new ValidationException("Quantity out of Stock");
				}
			} catch (SQLException e) {
				throw new DbException(ErrorConstants.INVALID_ADD);
			}
		}
		return stockavailable;
	}

}
