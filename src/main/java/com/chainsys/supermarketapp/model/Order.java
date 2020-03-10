package com.chainsys.supermarketapp.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order {

	private int orderId;
	private int customerNo;
	private int totalAmount;
	private String status = "pending";
	private LocalDateTime orderedDate;

	private List<OrderItem> items = new ArrayList<>();

	public int getCustomerNo() {
		return customerNo;
	}

	public void setCustomerNo(int customerNo) {
		this.customerNo = customerNo;
	}

	public void setItems(List<OrderItem> items) {
		this.items = items;
	}

	public void addItem(OrderItem item) {
		items.add(item);
	}

	public List<OrderItem> getItems() {
		return items;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getCustomerno() {
		return customerNo;
	}

	public void setCustomerno(int customerno) {
		this.customerNo = customerno;
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

	public LocalDateTime getOrderedDate() {
		return orderedDate;
	}

	public void setOrderedDate(LocalDateTime orderedDate) {
		this.orderedDate = orderedDate;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", customerNo=" + customerNo + ", totalAmount=" + totalAmount + ", status="
				+ status + ", orderedDate=" + orderedDate + ", items=" + items + "]";
	}

}