package com.capg.onlinesportsshopee.model;

import org.springframework.stereotype.Component;

import com.capg.onlinesportsshopee.bean.Customer;


@Component
public class OrderDTO  {
	private long orderId;
	private double amount;
	private String billingDate;
	private Customer customer;
	public OrderDTO() {
		super();
		
	}
	public OrderDTO(int orderId, double amount, String  billingDate, long userId) {
		super();
		this. orderId= orderId;
		this.amount = amount;
		this.billingDate = billingDate;
		this.customer = new Customer(userId);
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
	public String getBillingDate() {
		return billingDate;
	}
	public void setBillingDate(String billingDate) {
		this.billingDate = billingDate;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	@Override
	public String toString() {
		return "OrderDTO [orderId=" + orderId + ", amount=" + amount + ", billingDate=" + billingDate + ", customer="
				+ customer + "]";
	}
	
	
	
    
	

}