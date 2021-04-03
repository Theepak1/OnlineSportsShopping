package com.capg.onlinesportsshopee.bean;

import java.time.LocalDate;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "customers")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "userid")
	private long userId;

	@Column(name = "name",nullable=false,length=20)
	private String name;

	@Column(name = "email",nullable=false,unique=true, length = 25)
	private String email;

	@Column(name = "contactno",nullable=false,unique=true, length = 10)
	private String contactNo;

	@Column(name = "dob",nullable = false)
	private LocalDate dob;

	@ManyToMany(targetEntity = Address.class,fetch = FetchType.EAGER,mappedBy = "addressId",cascade = CascadeType.ALL)
	@JoinColumn(name="addressId",nullable = false)
	private Address address;

	public Customer(String name, String email, String contactNo, LocalDate dob, Address address) {
		super();
		this.name = name;
		this.email = email;
		this.contactNo = contactNo;
		this.dob = dob;
		this.address = address;
	}

	public Customer() {
		super();
	}

	
	public Customer(long userId, String name, String email, String contactNo, LocalDate dob, Address address) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.contactNo = contactNo;
		this.dob = dob;
		this.address = address;
	}
	
	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Customer [userId=" + userId + ", name=" + name + ", email=" + email + ", contactNo=" + contactNo
				+ ", dob=" + dob + ", address=" + address + "]";
	}

	

}
