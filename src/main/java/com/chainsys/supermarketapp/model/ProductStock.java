package com.chainsys.supermarketapp.model;

import java.sql.Date;
import java.time.LocalDate;

public class ProductStock {
	private int productno;
	private int stockid;
	private int quantity;
	private LocalDate productarrival;
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
		return productno;
	}
	public void setProductno(int productno) {
		this.productno = productno;
	}
	public int getStockid() {
		return stockid;
	}
	public void setStockid(int stockid) {
		this.stockid = stockid;
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
		return "ProductStock [productno=" + productno + ", stockid=" + stockid + ", quantity=" + quantity
				+ ", productarrival=" + productarrival + ", productarrival1=" + productarrival1 + ", experydate1="
				+ experydate1 + ", experydate=" + experydate + "]";
	}
	

}
