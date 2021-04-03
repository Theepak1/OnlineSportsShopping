package com.capg.onlinesportsshopee.bean;

import java.time.LocalDate;

public class Product {
	private long productId;
	private String productName;
	private String category;
	private String description;
	private String brand; 
	private String color;
	private String size;
	private String mrp;
	private int discount;
	private double priceAfterDiscount;
	private boolean inStock;
	private LocalDate estimatedDelivery;
}
