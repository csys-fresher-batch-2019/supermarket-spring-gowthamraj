package com.chainsys.supermarketapp.model;

public class Billorder {
	private int proId;
	private int productId;
	private int customerNo;
	private float price;
	private int quantity;
	private int billItemId;
	private int billNo;

	public int getProId() {
		return proId;
	}

	public void setProId(int proId) {
		this.proId = proId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getCustomerNo() {
		return customerNo;
	}

	public void setCustomerNo(int customerNo) {
		this.customerNo = customerNo;
	}

	public int getProid() {
		return proId;
	}

	public void setProid(int proid) {
		this.proId = proid;
	}

	public int getProductid() {
		return productId;
	}

	public void setProductid(int productid) {
		this.productId = productid;
	}

	public int getCustomerno() {
		return customerNo;
	}

	public void setCustomerno(int customerno) {
		this.customerNo = customerno;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getBillItemId() {
		return billItemId;
	}

	public void setBillItemId(int billItemId) {
		this.billItemId = billItemId;
	}

	public int getBillNo() {
		return billNo;
	}

	public void setBillNo(int billNo) {
		this.billNo = billNo;
	}

	public int getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}

	@Override
	public String toString() {
		return "Billorder [proId=" + proId + ", productId=" + productId + ", customerNo=" + customerNo + ", price="
				+ price + ", quantity=" + quantity + ", billItemId=" + billItemId + ", billNo=" + billNo
				+ ", totalAmount=" + totalAmount + "]";
	}

	private int totalAmount;
}