package com.capg.onlinesportsshopee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.onlinesportsshopee.service.IProductService;
import com.capg.onlinesportsshopee.bean.Product;
import com.capg.onlinesportsshopee.exceptions.ProductServiceException;
import com.capg.onlinesportsshopee.service.IProductService;


@RestController
@RequestMapping("/sports")

public class ProductController {
	@Autowired
	private IProductService productservice;

	@PostMapping("/product")
	public ResponseEntity<Product> addProduct(@RequestBody Product product) {
		Product resultProduct = productservice.addProduct(product);
		return new ResponseEntity<Product>(resultProduct,HttpStatus.OK) ;  
	}

	@DeleteMapping("/product/{id}")
	public void deleteProduct(@PathVariable long id) throws ProductServiceException {
		productservice.removeProduct(id);
	}

	@PutMapping("/product/{id}")
	public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
		Product resultProduct = productservice.updateProduct(product.getProductId(), product);
		return new ResponseEntity<Product>(resultProduct, HttpStatus.OK);
	}

	@GetMapping("/products/{id}")
	public ResponseEntity<Product> findProduct(@PathVariable long id) throws ProductServiceException {
		Product resultProduct = productservice.getProduct(id);
		return new ResponseEntity<Product>(resultProduct, HttpStatus.OK);
	}

	@GetMapping("/product/all")
	public List<Product> getProducts() {
		return productservice.getAllProduct();
	}

	@GetMapping("/product1/{name}")
	public List<Product> getProductsByName(@PathVariable String name) {

		return productservice.findByProductName(name);
	}

	@GetMapping("/product2/{sizes}")
	public List<Product> getProductsBySize(@PathVariable int size) {
		return productservice.findBySize(size);
	}

	@GetMapping("/product3/{color}")
	public List<Product> getProductsByColor(@PathVariable String color) {
		return productservice.findByColor(color);
	}

	@GetMapping("/product4/{price}")
	public List<Product> getProductsByPrice(@PathVariable double price) {
		return productservice.findByPrice(price);
	}
}
