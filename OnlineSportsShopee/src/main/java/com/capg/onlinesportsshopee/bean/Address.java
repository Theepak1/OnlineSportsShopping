package com.capg.onlinesportsshopee.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Address")
public class Address {

	@Id
	@Column(name = "addressId")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int addressId;
	
	@Column(name="doorno",nullable = false)
	private String doorNo;
	
	@Column(name="street",nullable = false)
	private String street;
	
	@Column(name="area",nullable = false)
	private String area;
	
	@Column(name="city",nullable = false)
	private String city;
	
	@Column(name="state",nullable = false)
	private String state;
	
	@Column(name="pincode",nullable = false,length=6)
	private int pinCode;

	public String getDoorNo() {
		return doorNo;
	}

	public void setDoorNo(String doorNo) {
		this.doorNo = doorNo;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getPinCode() {
		return pinCode;
	}

	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}

	public int getAddressId() {
		return addressId;
	}

	public Address(String doorNo, String street, String area, String city, String state, int pinCode) {
		super();
		this.doorNo = doorNo;
		this.street = street;
		this.area = area;
		this.city = city;
		this.state = state;
		this.pinCode = pinCode;
	}

	public Address() {
		super();
	}

	@Override
	public String toString() {
		return "Address [doorNo=" + doorNo + ", street=" + street + ", area=" + area + ", city=" + city + ", state="
				+ state + ", pinCode=" + pinCode + "]";
	}

}
