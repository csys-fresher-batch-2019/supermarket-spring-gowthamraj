package com.chainsys.supermarketapp.model;

import java.sql.Date;
import java.time.LocalDate;

public class ProductStock {
	private int productNo;
	private int stockId;
	private int quantity;
	private LocalDate productarrival;
	private LocalDate expiryDate;
	
	private Date productarrival1;
	private Date experydate1;
	

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


	public LocalDate getExpiryDate() {
		return expiryDate;
	}


	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}


	public Date getProductarrival1() {
		return productarrival1;
	}


	public void setProductarrival1(Date productarrival1) {
		this.productarrival1 = productarrival1;
	}


	public Date getExperydate1() {
		return experydate1;
	}


	public void setExperydate1(Date experydate1) {
		this.experydate1 = experydate1;
	}


	@Override
	public String toString() {
		return "ProductStock [productNo=" + productNo + ", stockId=" + stockId + ", quantity=" + quantity
				+ ", productarrival=" + productarrival + ", expiryDate=" + expiryDate + ", productarrival1="
				+ productarrival1 + ", experydate1=" + experydate1 + "]";
	}



}
