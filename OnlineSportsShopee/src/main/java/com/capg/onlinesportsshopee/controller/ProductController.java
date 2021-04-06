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

import com.capg.onlinesportsshopee.bean.Product;
import com.capg.onlinesportsshopee.exceptions.ProductServiceException;
import com.capg.onlinesportsshopee.model.ProductDTO;
import com.capg.onlinesportsshopee.service.IProductService;


@RestController
@RequestMapping("/api/oss")

public class ProductController {
	@Autowired
	private IProductService productservice;

	@PostMapping("/addProduct")
	public ResponseEntity<ProductDTO> addProduct(@RequestBody Product product) {
		ProductDTO resultProduct = productservice.addProduct(product);
		return new ResponseEntity<ProductDTO>(resultProduct,HttpStatus.OK) ;  
	}

	@DeleteMapping("/deleteProduct/{productId}")
	public void deleteProduct(@PathVariable long productId) {
		productservice.removeProduct(productId);
	}

	@PutMapping("/updateProduct")
	public ResponseEntity<ProductDTO> updateProduct(@RequestBody Product product) {
		ProductDTO resultProduct = productservice.updateProduct(product.getProductId(), product);
		return new ResponseEntity<ProductDTO>(resultProduct, HttpStatus.OK);
	}

	@GetMapping("/getProduct/{id}")
	public ResponseEntity<ProductDTO> findProduct(@PathVariable long productId) throws ProductServiceException {
		ProductDTO resultProduct = productservice.getProduct(productId);
		return new ResponseEntity<ProductDTO>(resultProduct, HttpStatus.OK);
	}

	@GetMapping("/getAllProduct")
	public List<ProductDTO> getProducts() {
		return productservice.getAllProduct();
	}

	@GetMapping("/getProductsByName/{productName}")
	public List<ProductDTO> getProductsByName(@PathVariable String productName) {

		return productservice.findByProductName(productName);
	}

	@GetMapping("/getProductsBySize/{size}")
	public List<ProductDTO> getProductsBySize(@PathVariable int size) {
		return productservice.findBySize(size);
	}

	@GetMapping("/getProductsByColor/{color}")
	public List<ProductDTO> getProductsByColor(@PathVariable String color) {
		return productservice.findByColor(color);
	}

	@GetMapping("/getProductsByPrice/{priceAfterDiscount}")
	public List<ProductDTO> getProductsByPrice(@PathVariable double priceAfterDiscount) {
		return productservice.findByPrice(priceAfterDiscount);
	}
}
