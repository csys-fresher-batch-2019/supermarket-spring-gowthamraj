package com.chainsys.supermarketapp.model;

public class OrderItemDTO {
	
  private int quantity;
  public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
private int itemId;
  
@Override
public String toString() {
	return "OrderItemDTO [quantity=" + quantity + ", itemId=" + itemId + "]";
}
public int getItemId() {
	return itemId;
}
public void setItemId(int itemId) {
	this.itemId = itemId;
}
}
