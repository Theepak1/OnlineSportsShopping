<<<<<<< HEAD
package com.capg.onlinesportsshopee.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="cart")
public class Cart extends Product{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="cartid" )
	 private long cartId;
	 
	@Column(name="imagename")
	private String imageName;
	
	@Column(name="productname", nullable=false, length=20)
	@NotBlank(message="ProductName should not be blank")
	 private String productName;
	
	@Column(name="quantity", nullable=false)
	@NotBlank(message="Quantity should be specified")
	 private int quantity;
	
	@Column(name="price")
	 private double price;
	
	@Column(name = "total")
	 private double total;
	
	
	
	public Cart() {
		
	}
	
	
	
	public Cart(long cartId, String imageName, String productName, int quantity, double price, double total) {
		super();
		this.cartId = cartId;
		this.imageName = imageName;
		this.productName = productName;
		this.quantity = quantity;
		this.price = price;
		this.total = total;
	}



	public long getCartId() {
		return cartId;
	}
	public void setCartId(long cartId) {
		this.cartId = cartId;
	}
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", imageName=" + imageName + ", productName=" + productName + ", quantity="
				+ quantity + ", price=" + price + ", total=" + total + "]";
	}
=======
package com.capg.onlinesportsshopee.bean;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="cart")
public class Cart implements Serializable{
	
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cartid" )
	 private long cartId;
	 
	@Column(name="imagename")
	private String imageName;
	
	@Column(name="productname", nullable=false, length=20)
	@NotBlank(message="ProductName should not be blank")
	 private String productName;
	
	@Column(name="quantity", nullable=false)
	@NotBlank(message="Quantity should be specified")
	 private int quantity;
	
	@Column(name="price")
	 private double price;
	
	@Column(name = "total")

	 private double total;
	
	
	
	public Cart() {
		
	}
	
	
	
	public Cart(long cartId, String imageName, String productName, int quantity, double price, double total) {
		super();
		this.cartId = cartId;
		this.imageName = imageName;
		this.productName = productName;
		this.quantity = quantity;
		this.price = price;
		this.total = total;
	}



	public long getCartId() {
		return cartId;
	}
	public void setCartId(long cartId) {
		this.cartId = cartId;
	}
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", imageName=" + imageName + ", productName=" + productName + ", quantity="
				+ quantity + ", price=" + price + ", total=" + total + "]";
	}
	 
>>>>>>> branch 'master' of https://github.com/Theepak1/OnlineSportsShopping.git
}