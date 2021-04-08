package com.capg.onlinesportsshopee;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.capg.onlinesportsshopee.bean.Product;
import com.capg.onlinesportsshopee.exceptions.ProductServiceException;
import com.capg.onlinesportsshopee.model.ProductDTO;
import com.capg.onlinesportsshopee.service.IProductService;
import com.capg.onlinesportsshopee.service.ProductServiceImpl;
import com.capg.onlinesportsshopee.util.ProductUtil;

@SpringBootTest
public class ProductServiceImplTest {

	@Autowired
	IProductService productservice;

	@Autowired
	ProductServiceImpl service;

	List<Product> list = new ArrayList<>();

	@Disabled
	@Test
	void testAddProduct() {
		Product productTemp1 = new Product(1, "Nike Airforce", "Shoes", "Sports shoes", "Nike", "white", 5, 4000, 10,
				3000, true, LocalDate.parse("2021-04-10"), 1, "shoe image", "Nike Airforce", 2, 4000, 8000);
		try {
			productservice.addProduct(productTemp1);
		} catch (ProductServiceException exception) {
			assertEquals("Enter valid product details", exception.getMessage());

		}
	}

	@Disabled
	@Test
	void testAddProduct2() {// make changes

		Product productTemp1 = new Product(1, "Nike Airforce", "Shoes", "Sports shoes", "Nike", "white", 5, 4000, 10,
				3000, true, LocalDate.parse("2021-04-10"), 1, "shoe image", "Nike Airforce", 2, 4000, 8000);

		assertEquals(productTemp1.getProductName(), service.addProduct(productTemp1).getProductName());

	}

	@Disabled
	@Test
	void testRemoveProduct() {
		try {
			service.removeProduct(9);
		} catch (ProductServiceException exception) {
			assertEquals("Product does not exist to delete", exception.getMessage());
		}

	}
	

	@Disabled
	@Test
	void testUpdateProduct() {// make changes
		Product productTemp = new Product(1, "Nike Airforce", "Shoes", "Sports shoes", "Nike", "white", 5, 4000, 10,
				3000, true, LocalDate.parse("2021-04-10"), 1, "shoe image", "Nike Airforce", 2, 4000, 8000);
		long productId = productTemp.getProductId();
		assertEquals("updated", service.updateProduct(productId, productTemp).getProductId());

	}

	@Disabled
	@Test
	void testUpdatePayment2() {
		Product productTemp = new Product(1, "Nike Airforce", "Shoes", "Sports shoes", "Nike", "white", 5, 4000, 10,
				3000, true, LocalDate.parse("2021-04-10"), 1, "shoe image", "Nike Airforce", 2, 4000, 8000);
		long productId = productTemp.getProductId();
		try {
			service.updateProduct(productId, productTemp);
		} catch (ProductServiceException exception) {
			assertEquals("Product does not exist for ProductId", exception.getMessage());
		}
	}

	@Disabled
	@Test
	void testGetProductDetails() {
		ProductDTO product = service.getProduct(1);

		assertEquals("Football", product.getProductName());

	}

	@Disabled
	@Test
	void testGetProductDetails2() {
		try {
			service.getProduct(2);
		} catch (ProductServiceException exception) {
			assertEquals("Product does not exist for productId", exception.getMessage());
		}
	}

	@Disabled
	@Test
	void testGetAllProductDetails2() {
		ProductDTO product1 = service.getProduct(2);
		ProductDTO product2 = service.getProduct(3);
		Product product01 = ProductUtil.convertToProduct(product1);
		Product product02 = ProductUtil.convertToProduct(product2);
		list.add(product01);
		list.add(product02);
		assertNotNull(list);
	}

}
