package com.chainsys.supermarketapp.model;

import java.time.LocalDate;

public class Employee {
	private int employeeId;
	private String employeeName;
	private LocalDate dob;
	private LocalDate doj;
	private int mobileNo;
	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public int getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(int mobileNo) {
		this.mobileNo = mobileNo;
	}

	private String address;

	public int getEmployeeid() {
		return employeeId;
	}

	public void setEmployeeid(int employeeid) {
		this.employeeId = employeeid;
	}

	public String getEmployeename() {
		return employeeName;
	}

	public void setEmployeename(String employeename) {
		this.employeeName = employeename;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public LocalDate getDoj() {
		return doj;
	}

	public void setDoj(LocalDate doj) {
		this.doj = doj;
	}

	public int getMobileno() {
		return mobileNo;
	}

	public void setMobileno(int mobileno) {
		this.mobileNo = mobileno;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", dob=" + dob + ", doj=" + doj
				+ ", mobileNo=" + mobileNo + ", address=" + address + "]";
	}
}
