package com.capg.onlinesportsshopee.bean;
import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;


@Entity
@Table(name="orders")
public class Order implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name= "order_id")
	@NotBlank(message="Order Id should not be blank")
	private long orderId;
	
	@Column(name= "amount")
	@NotBlank(message="Amount should not be blank")
	private double amount;
	
	//@Temporal(TemporalType.DATE)
	@Column(name = "billing_date")
	@NotBlank(message="Billing Date should not be blank")
	private LocalDate billingDate;
	
	@ManyToOne(cascade = {CascadeType.ALL},fetch=FetchType.EAGER)
	@JoinColumn(name="cust_Id",referencedColumnName = "userid")
	private Customer customer;

	public Order() {
		super();
	}
	public Order(long orderId, double amount, LocalDate billingDate,Customer customer) {
		super();
		this. orderId= orderId;
		this.amount = amount;
		this.billingDate = billingDate;
		this.customer =customer;
		
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
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", amount=" + amount + ", billingDate=" + billingDate + ", customer="
				+ customer + "]";
	}


	
	

}


