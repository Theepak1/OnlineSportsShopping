package com.capg.onlinesportsshopee.repo;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.capg.onlinesportsshopee.bean.Product;

@Repository
public interface IProductRepository extends JpaRepository<Product,Long>{
	

	public List<Product> findByProductName(String productName);
	public List<Product> findBySize(int size);
	public List<Product> findByColor(String color);
	public List<Product> findByPriceAfterDiscount(double priceAfterDiscount);
	
	/*
	 * public Product addProduct(Product product); public Product removeProduct(long
	 * id); public Product updateProduct(long id, Product product); public Product
	 * getProduct(long id); public List<Product> getAllProduct(); public
	 * List<Product> getProductsByName(); public List<Product> getProductsBySize();
	 * public List<Product> getProductsByPrice(); public List<Product>
	 * getProductsByColor();
	 */


}