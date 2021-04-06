package com.capg.onlinesportsshopee.model;
import java.time.LocalDate;



import org.springframework.stereotype.Component;

@Component
public class OrderDTO  {
	private long orderId;
	private double amount;
	private LocalDate billingDate;
	private int custId;
	public OrderDTO() {
		super();
		
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
	public LocalDate getBillingDate() {
		return billingDate;
	}
	public void setBillingDate(LocalDate billingDate) {
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
	public OrderDTO(int orderId, double amount, LocalDate billingDate, int custId) {
		super();
		this. orderId= orderId;
		this.amount = amount;
		this.billingDate = billingDate;
		this.custId = custId;
	}

	

}
	
