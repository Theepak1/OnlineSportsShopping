package com.capg.onlinesportsshopee.repo;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.onlinesportsshopee.bean.Product;

@Repository
public interface IProductRepository extends JpaRepository<Product,Long>{
	

	
	/*
	 * public Product addProduct(Product product); public Product removeProduct(long
	 * id); public Product updateProduct(long id, Product product); public Product
	 * getProduct(long id); public List<Product> getAllProduct(); public
	 * List<Product> getProductsByName(); public List<Product> getProductsBySize();
	 * public List<Product> getProductsByPrice(); public List<Product>
	 * getProductsByColor();
	 */


}
