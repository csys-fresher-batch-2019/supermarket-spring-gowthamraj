package com.chainsys.supermarketapp.model;

import java.time.LocalDate;

public class OrderItem {

	private int id;
	private int orderId;

	private int productId;

	private int quantity;

	private String customerName;

	private int customerNo;

	private LocalDate billdate;

	private String paymentStatus;

	private int price;

	private int totalAmount;

	private String status = "PENDING";

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public int getCustomerNo() {
		return customerNo;
	}

	public void setCustomerNo(int customerNo) {
		this.customerNo = customerNo;
	}

	public LocalDate getBilldate() {
		return billdate;
	}

	public void setBilldate(LocalDate billdate) {
		this.billdate = billdate;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "OrderItem [id=" + id + ", orderId=" + orderId + ", productId=" + productId + ", quantity=" + quantity
				+ ", customerName=" + customerName + ", customerNo=" + customerNo + ", billdate=" + billdate
				+ ", paymentStatus=" + paymentStatus + ", price=" + price + ", totalAmount=" + totalAmount + ", status="
				+ status + "]";
	}

}
