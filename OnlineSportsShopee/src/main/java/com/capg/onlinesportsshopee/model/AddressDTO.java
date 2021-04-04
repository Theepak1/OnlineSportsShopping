package com.capg.onlinesportsshopee.model;

import javax.persistence.Column;
import javax.persistence.Id;
import org.springframework.stereotype.Component;

@Component
public class AddressDTO {

	private int addressId;
	private String doorNo;
	private String street;
	private String area;
	private String city;
	private String state;
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
	
	public AddressDTO(String doorNo, String street, String area, String city, String state, int pinCode) {
		super();
		this.doorNo = doorNo;
		this.street = street;
		this.area = area;
		this.city = city;
		this.state = state;
		this.pinCode = pinCode;
	}
	
	public AddressDTO()
	{
		super();
	}
	
	@Override
	public String toString() {
		return "Address [doorNo=" + doorNo + ", street=" + street + ", area=" + area + ", city=" + city + ", state="
				+ state + ", pinCode=" + pinCode + "]";
	}
	
}