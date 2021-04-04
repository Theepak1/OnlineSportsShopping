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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "Customers")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "userid")
	private long userId;

	@Column(name = "name",length=20)
	@NotBlank(message="Name should not be blank")
	private String name;

	@Column(name = "email",unique=true, length = 25)
	@NotBlank(message="EmailId should not be blank")
	private String email;

	@Column(name = "contactno",unique=true, length = 10)
	@NotBlank(message="ContactNo should not be blank")
	private String contactNo;

	@Column(name = "dob")
	@NotBlank(message="Date of Birth should not be blank")
	private String dob;

	/*
	 * @ManyToMany(targetEntity = Address.class,fetch = FetchType.EAGER,mappedBy =
	 * "addressId",cascade = CascadeType.ALL)
	 * 
	 * @JoinColumn(name="addressId",nullable = false)
	 */
	
	@OneToOne(cascade = {CascadeType.ALL})
	private Address address;

	public Customer(String name, String email, String contactNo, String dob,String doorNo, String street, String area, String city, String state, int pinCode) {
		super();
		this.name = name;
		this.email = email;
		this.contactNo = contactNo;
		this.dob = dob;
		this.address =  new Address(doorNo,street,area,city,state,pinCode);
	}

	public Customer() {
		super();
	}

	
	public Customer(long userId, String name, String email,String contactNo,String dob, String doorNo, String street, String area, String city, String state, int pinCode) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.contactNo = contactNo;
		this.dob = dob;
		this.address = new Address(doorNo,street,area,city,state,pinCode);
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

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
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
		return "Customer [userId=" + userId + ", name=" + name + ", email=" + email + ", contactNo=" + contactNo+ ", "+ "dob=" + dob + ", address=" + address + "]";
	}

	

}
