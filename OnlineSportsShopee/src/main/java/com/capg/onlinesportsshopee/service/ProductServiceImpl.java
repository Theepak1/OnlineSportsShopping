package com.capg.onlinesportsshopee.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capg.onlinesportsshopee.bean.Product;
import com.capg.onlinesportsshopee.exceptions.ProductServiceException;
import com.capg.onlinesportsshopee.model.ProductDTO;
import com.capg.onlinesportsshopee.repo.IProductRepository;
import com.capg.onlinesportsshopee.util.ProductUtil;


@Service
public class ProductServiceImpl implements IProductService {

	 @Autowired
	 private IProductRepository repo;
	

	@Override
	public ProductDTO addProduct(Product product) throws ProductServiceException {
		Optional<Product> product1= repo.findById(product.getProductId());
		if (product1.isEmpty()) {
			Product addProduct =  repo.save(product);
			return ProductUtil.convertToProductDto(addProduct);
		} else {
			throw new ProductServiceException("Product already exists");
		}
	}

	@Override
	public void removeProduct(long productId) throws ProductServiceException {
	Optional<Product> product1=repo.findById(productId);
	if(!product1.isEmpty()) {
		if(product1.isPresent())
		{
			repo.delete(product1.get());
		}
	}
	else 
		throw new ProductServiceException("Product does not exist to delete");
		
}

	
	@Override
	public ProductDTO updateProduct(long productId, Product product) throws ProductServiceException {
		Optional<Product> product1=repo.findById(productId);
		if(product1.isEmpty()) {
			throw new ProductServiceException("Product not found");
		}
		else
		{
			Product updateProduct = repo.save(product);
			return ProductUtil.convertToProductDto(updateProduct);
		}
			
		
	}


	@Override
	public ProductDTO getProduct(long productId) throws ProductServiceException {
		Optional<Product> product=repo.findById(productId);
		if(!product.isEmpty()) {
			Product getProduct = repo.findById(productId).orElse(null);
			return ProductUtil.convertToProductDto(getProduct);
			
		}
		else
		{
			throw new ProductServiceException("Given product id does not exists");
		}
	
		
	}


	@Override
	public List<ProductDTO> getAllProduct() throws ProductServiceException {
		List<Product> productList= repo.findAll();
		if(productList.isEmpty()) {
			throw new ProductServiceException("Products not found");
		}
		return ProductUtil.convertToProductDtoList(productList);
	}


	

	@Override
	public List<ProductDTO> findByProductName(String productName) throws ProductServiceException {
	
	List<Product> productList= repo.findByProductName(productName);
	if(productList.isEmpty()) {
		throw new ProductServiceException("Products not found");
	}
	return ProductUtil.convertToProductDtoList(productList);
}


	@Override
	public List<ProductDTO> findBySize(int size) throws ProductServiceException {
		List<Product> productList= repo.findBySize(size);
		if(productList.isEmpty()) {
			throw new ProductServiceException("Products with required sizes not found");
		}
		return ProductUtil.convertToProductDtoList(productList);
	}


	@Override
	public List<ProductDTO> findByPriceAfterDiscount(double priceAfterDiscount ) throws ProductServiceException {
	List<Product> productList= repo.findByPriceAfterDiscount(priceAfterDiscount);
	if(productList.isEmpty()) {
		throw new ProductServiceException("Products with mentioed price not found");
	}
	return ProductUtil.convertToProductDtoList(productList);
}



	@Override
	public List<ProductDTO> findByColor(String color) throws ProductServiceException {
		List<Product> productList= repo.findByColor(color);
		if(productList.isEmpty()) {
			throw new ProductServiceException("Products with mentioned color not found");
		}
		return ProductUtil.convertToProductDtoList(productList);

	}

}

