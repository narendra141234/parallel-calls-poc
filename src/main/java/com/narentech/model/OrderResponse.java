package com.narentech.model;

public class OrderResponse {
	
	private String name;
	private float price;
	private int qty;
	private String status;
	private String desc;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	@Override
	public String toString() {
		return "OrderResponse [name=" + name + ", price=" + price + ", qty=" + qty + ", status=" + status + ", desc="
				+ desc + "]";
	}
	
	

}
