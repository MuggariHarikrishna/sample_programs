package com.dto;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component
public class Order {

	private int orderNo;
	private String orderName;
	private int quantity;
	private Date createdDate;
	private Date modifiedDate;

	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	@Override
	public String toString() {
		return "Order [orderNo=" + orderNo + ", orderName=" + orderName + ", quantity=" + quantity + ", createdDate="
				+ createdDate + ", modifiedDate=" + modifiedDate + "]";
	}

}
