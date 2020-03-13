package com.chainsys.supermarketapp.model;

import java.util.ArrayList;
import java.util.List;

public class OrderDTO {
	
	private int customerId;
	private List<OrderItemDTO> items  = new ArrayList<OrderItemDTO>() ;
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public List<OrderItemDTO> getItems() {
		return items;
	}
	public void setItems(List<OrderItemDTO> items) {
		this.items = items;
	}
	@Override
	public String toString() {
		return "OrderDTO [customerId=" + customerId + ", items=" + items + "]";
	}


}
