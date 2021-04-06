package com.capg.onlinesportsshopee.service;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import com.capg.onlinesportsshopee.bean.Product;
import com.capg.onlinesportsshopee.exceptions.ProductServiceException;
import com.capg.onlinesportsshopee.repo.IProductRepository;


@Service
@Transactional
@Repository
public class ProductServiceImpl implements IProductService {

	@Autowired
	 IProductRepository repo;
	

	@Override
	public Product addProduct(Product product) {
		Optional<Product> product1= repo.findById(product.getProductId());
		if (product1.isEmpty()) {
			return repo.saveAndFlush(product);
		} else {
			throw new ProductServiceException("Product already exists");
		}
	}

	@Override
	public void removeProduct(long id) {
	Optional<Product> product1=repo.findById(id);
	if(product1.isEmpty()) {
		throw new ProductServiceException("Product doesnt exist to delete");
	}
	else 
		repo.delete(product1.get());
}

	
	@Override
	public Product updateProduct(long id, Product product) {
		Optional<Product> product1=repo.findById(id);
		if(product1.isEmpty()) {
			throw new ProductServiceException("Product not found");
		}
		else
			repo.save(product);
		return product;
	}


	@Override
	public Product getProduct(long id) {
		Optional<Product>product=repo.findById(id);
		if(product.isEmpty()) {
			throw new ProductServiceException("Given product id does not exists");
		}
	
		return product.get();
	}


	@Override
	public List<Product> getAllProduct() {
		List<Product> product= repo.findAll();
		if(product.isEmpty()) {
			throw new ProductServiceException("Products not found");
		}
		return product;
	}


	

	@Override
	public List<Product> findByProductName(String productName) {
	
	List<Product> product= repo.findByProductName(productName);
	if(product.isEmpty()) {
		throw new ProductServiceException("Products not found");
	}
	return product;
}


	@Override
	public List<Product> findBySize(int size) {
		List<Product> product= repo.findBySize(size);
		if(product.isEmpty()) {
			throw new ProductServiceException("Products with required sizes not found");
		}
		return product;
	}


	@Override
	public List<Product> findByPrice(double price ) {
	List<Product> product= repo.findByPriceAfterDiscount(price);
	if(product.isEmpty()) {
		throw new ProductServiceException("Products with mentioed price not found");
	}
	return product;
}



	@Override
	public List<Product> findByColor(String color) {
		List<Product> product= repo.findByColor(color);
		if(product.isEmpty()) {
			throw new ProductServiceException("Products with mentioned color not found");
		}
		return product;

	}

}