package com.chainsys.supermarketapp.model;

public class CustomerCard {
	private String customerName;
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public long getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	private long contactNumber;
	private String address;
	@Override
	public String toString() {
		return "CustomerCard [customerName=" + customerName + ", contactNumber=" + contactNumber + ", address="
				+ address + "]";
	}



}
