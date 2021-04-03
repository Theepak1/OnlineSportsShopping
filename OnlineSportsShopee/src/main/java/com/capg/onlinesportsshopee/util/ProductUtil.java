
package com.capg.onlinesportsshopee.util;
import java.util.ArrayList;
import java.util.List;


import com.capg.onlinesportsshopee.bean.Product;
import com.capg.onlinesportsshopee.model.ProductDTO;

public class ProductUtil {

public static List<ProductDTO> convertToProductDtoList(List<Product> list)
	{
		List<ProductDTO> 	ProductDtoList = new ArrayList<ProductDTO>();
		for (Product product : list)
			ProductDtoList.add(convertToProductDto(product));
	    return ProductDtoList;
	}
	
	public static Product convertToProduct(ProductDTO productDto) {
		Product product = new Product();
		
		product.setProductId(productDto.getProductId());
		product.setProductName(productDto.getProductName());
		product.setCategory(productDto.getCategory());
		product.setDescription(productDto.getDescription());
		product.setBrand(productDto.getBrand());
		product.setColor(productDto.getColor());
		product.setSize(productDto.getSize());
		product.setMrp(productDto.getMrp());
		product.setDiscount(productDto.getDiscount());
		product.setPriceAfterDiscount(productDto.getPriceAfterDiscount());
		product.setInStock(productDto.isInStock());
		product.setEstimatedDelivery(productDto.getEstimatedDelivery());
		
		return product;
	}
	
	public static ProductDTO convertToProductDto(Product product) {
		ProductDTO productDto = new ProductDTO();
		
		product.setProductId(productDto.getProductId());
		product.setProductName(productDto.getProductName());
		product.setCategory(productDto.getCategory());
		product.setDescription(productDto.getDescription());
		product.setBrand(productDto.getBrand());
		product.setColor(productDto.getColor());
		product.setSize(productDto.getSize());
		product.setMrp(productDto.getMrp());
		product.setDiscount(productDto.getDiscount());
		product.setPriceAfterDiscount(productDto.getPriceAfterDiscount());
		product.setInStock(productDto.isInStock());
		product.setEstimatedDelivery(productDto.getEstimatedDelivery());
		
		return productDto;
	}
	
	

}