package com.chainsys.supermarketapp.model;

import java.sql.Date;
import java.time.LocalDate;

public class ProductStock {
	private int productNo;
	private int stockId;
	private int quantity;
	private LocalDate productarrival;
	private LocalDate expiryDate;
	public int getProductNo() {
		return productNo;
	}

	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}

	public int getStockId() {
		return stockId;
	}

	public void setStockId(int stockId) {
		this.stockId = stockId;
	}

	public LocalDate getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}

	private Date productarrival1;
	private Date experydate1;

	public Date getExperydate1() {
		return experydate1;
	}

	public void setExperydate1(Date experydate1) {
		this.experydate1 = experydate1;
	}

	private LocalDate experydate;

	public Date getProductarrival1() {
		return productarrival1;
	}

	public void setProductarrival1(Date productarrival1) {
		this.productarrival1 = productarrival1;
	}

	public int getProductno() {
		return productNo;
	}

	public void setProductno(int productno) {
		this.productNo = productno;
	}

	public int getStockid() {
		return stockId;
	}

	public void setStockid(int stockid) {
		this.stockId = stockid;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public LocalDate getProductarrival() {
		return productarrival;
	}

	public void setProductarrival(LocalDate productarrival) {
		this.productarrival = productarrival;
	}

	public LocalDate getExperydate() {
		return experydate;
	}

	public void setExperydate(LocalDate experydate) {
		this.experydate = experydate;
	}

	@Override
	public String toString() {
		return "ProductStock [productNo=" + productNo + ", stockId=" + stockId + ", quantity=" + quantity
				+ ", productarrival=" + productarrival + ", expiryDate=" + expiryDate + ", productarrival1="
				+ productarrival1 + ", experydate1=" + experydate1 + ", experydate=" + experydate + "]";
	}

}
