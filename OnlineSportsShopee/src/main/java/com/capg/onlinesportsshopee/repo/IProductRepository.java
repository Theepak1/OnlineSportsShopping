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
}