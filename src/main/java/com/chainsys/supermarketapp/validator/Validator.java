package com.chainsys.supermarketapp.validator;

import com.chainsys.supermarketapp.exception.ValidationException;
import com.chainsys.supermarketapp.model.Employee;
import com.chainsys.supermarketapp.model.Login;
import com.chainsys.supermarketapp.model.Order;
import com.chainsys.supermarketapp.model.Product;
import com.chainsys.supermarketapp.model.ProductStock;

public class Validator {

	public static void validateLoginForm(Login l) throws ValidationException {
		if (l.getUsername() == null || "".equals(l.getUsername().trim())) {
			throw new ValidationException("UserName cannot be blank/empty");
		}
		if (l.getPassword() == null || "".equals(l.getPassword().trim())) {
			throw new ValidationException("password cannot be blank/empty");
		}
	}

	public static void validateProductForm(Product p) throws ValidationException {
		if (p.getProductName() == null || "".equals(p.getProductName().trim())) {
			throw new ValidationException("Product cannot be blank/empty");
		}
		if (p.getPrice() == 0) {
			throw new ValidationException("product must not be zero or blank");
		}
	}

	public static void validateProductStockForm(ProductStock ps) throws ValidationException {
		if (ps.getProductNo() == 0) {
			throw new ValidationException("product number must not be zero or blank");
		}
		if (ps.getQuantity() == 0) {
			throw new ValidationException("Product Stock Quantity must not be zero or blank");
		}
		if (ps.getExpiryDate() == null) {
			throw new ValidationException("Product Expiry date must not be zero or blank");
		}
		if (ps.getProductarrival() == null) {
			throw new ValidationException("product Arrival Date must not be zero or blank");
		}

	}

	public static void validateEmployeeForm(Employee e) throws ValidationException {
		if (e.getEmployeeName() == null || "".equals(e.getEmployeeName().trim())) {
			throw new ValidationException("Employee Name must not be zero or blank");
		}
		if (e.getDob() == null) {
			throw new ValidationException("Date-Of-Birth must not be zero or blank");
		}
		if (e.getDoj() == null) {
			throw new ValidationException("Date-Of-Joining Date must not be zero or blank");
		}
		if (e.getAddress() == null) {
			throw new ValidationException("Address Date must not be zero or blank");
		}
	}

	public static void validateBillOrderForm(Order o) throws ValidationException {
		if (o.getCustomerNo() == 0) {
			throw new ValidationException("Customer number Item must not be zero or blank");
		}
		if (o.getOrderedDate() == null) {
			throw new ValidationException("Orderdate must not be zero or blank");
		}
		if (o.getStatus() == null) {
			throw new ValidationException("Status must not be zero or blank");
		}
		if (o.getOrderId() == 0) {
			throw new ValidationException("Order Id must not be zero or blank");
		}
		if (o.getTotalAmount() == 0) {
			throw new ValidationException("Total Amount must not be zero or blank");
		}
	}
}