package com.chainsys.supermarketapp.model;

public class Product {
	private int pid;
	private String productName;
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	private int price;
	private int active;

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getProductname() {
		return productName;
	}

	public void setProductname(String productname) {
		this.productName = productname;
	}

	

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [pid=" + pid + ", productName=" + productName + ", price=" + price + ", active=" + active + "]";
	}
}
