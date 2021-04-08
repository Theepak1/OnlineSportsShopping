package com.capg.onlinesportsshopee.model;

import org.springframework.stereotype.Component;

@Component
public class OrderDTO  {
	private long orderId;
	private double amount;
	private String billingDate;
	private int custId;
	public OrderDTO() {
		super();
		
	}
	public OrderDTO(int orderId, double amount, String  billingDate, int custId) {
		super();
		this. orderId= orderId;
		this.amount = amount;
		this.billingDate = billingDate;
		this.custId = custId;
	}
	
	public long getOrderId() {
		return orderId;
	}
	
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String  getBillingDate() {
		return billingDate;
	}
	public void setBillingDate(String  billingDate) {
		this.billingDate = billingDate;
	}
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	@Override
	public String toString() {
		return "OrderDTO [orderId=" + orderId + ", amount=" + amount + ", billingDate=" + billingDate + ", custId="
				+ custId +  "]";
	}
	

	

}