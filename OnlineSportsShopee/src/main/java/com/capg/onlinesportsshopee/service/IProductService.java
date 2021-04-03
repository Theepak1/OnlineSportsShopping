package com.capg.onlinesportsshopee.service;

import java.util.List;


import com.capg.onlinesportsshopee.bean.Product;

public interface IProductService {
	public Product addProdct(Product product);
	public Product removeProduct(long id);
	public Product updateProduct(long id, Product product);
	public Product getProduct(long id);
	public List<Product> getAllProduct();
	public List<Product> getProductsByName(String name);
	public List<Product> getProductsBySize();
	public List<Product> getProductsByPrice();
	public List<Product> getProductsByColor();
}
