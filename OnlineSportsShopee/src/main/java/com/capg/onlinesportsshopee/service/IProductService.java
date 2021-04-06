package com.capg.onlinesportsshopee.service;

import java.util.List;


import com.capg.onlinesportsshopee.bean.Product;

public interface IProductService {
	public Product addProduct(Product product);
	public void removeProduct(long id);
	public Product updateProduct(long id, Product product);
	public Product getProduct(long id);
	public List<Product> getAllProduct();
	public List<Product> findByPrice(double price);
	public List<Product> findByProductName(String productName);
	public List<Product> findByColor(String color);
	public List<Product> findBySize(int size);
}