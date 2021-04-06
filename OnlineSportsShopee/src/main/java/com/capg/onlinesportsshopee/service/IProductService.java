package com.capg.onlinesportsshopee.service;

import java.util.List;


import com.capg.onlinesportsshopee.bean.Product;
import com.capg.onlinesportsshopee.model.ProductDTO;

public interface IProductService {
	public ProductDTO addProduct(Product product);
	public void removeProduct(long id);
	public ProductDTO updateProduct(long id, Product product);
	public ProductDTO getProduct(long id);
	public List<ProductDTO> getAllProduct();
	public List<ProductDTO> findByPrice(double price);
	public List<ProductDTO> findByProductName(String productName);
	public List<ProductDTO> findByColor(String color);
	public List<ProductDTO> findBySize(int size);
}