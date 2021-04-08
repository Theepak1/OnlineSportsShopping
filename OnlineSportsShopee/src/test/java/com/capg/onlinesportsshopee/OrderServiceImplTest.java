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

import com.capg.onlinesportsshopee.bean.Address;
import com.capg.onlinesportsshopee.bean.Customer;
import com.capg.onlinesportsshopee.bean.Order;
import com.capg.onlinesportsshopee.bean.Payment;
import com.capg.onlinesportsshopee.bean.Product;
import com.capg.onlinesportsshopee.exceptions.OrderServiceException;
import com.capg.onlinesportsshopee.model.OrderDTO;
import com.capg.onlinesportsshopee.service.OrderServiceImpl;
import com.capg.onlinesportsshopee.util.OrderUtil;

@SpringBootTest
public class OrderServiceImplTest {

	@Autowired
	OrderServiceImpl service;

	List<Order> list = new ArrayList<>();



	@Disabled
	@Test
	void testAddOrder() {
		LocalDate expiryDate = LocalDate.parse("2025-05-25");
		Address address = new Address(63,"3", "7th street","porur", "chennai", "tamil nadu", 656565);
		Customer customer = new Customer(62,"syeddd"," syeddd@gmail.com","9040380958","2/4/1998",address);
		Product product = new Product(1,"Nike Airforce", " Shoes", " Sports shoes", " Nike", " white",
				 5, 4000, 10,  3000, true, expiryDate,1,"shoe image","Nike Airforce", 2, 3000, 6000);
		Payment payment = new Payment(25, "Debit", " Success", " Syed Samsudeen", 26, " 6321987425898521", expiryDate, 258);
		Order orderTemp = new Order(1, 8000, "25/3/2021", customer, product, payment);
		try {
			service.addOrder(orderTemp);
		} catch (OrderServiceException exception) {
			assertEquals("Enter the valid order detials", exception.getMessage());
		}
	}
	
	@Disabled
	@Test
	void testAddOrder2() {
		LocalDate expiryDate = LocalDate.parse("2025-05-25");
		Address address = new Address(63,"3", "7th street","porur", "chennai", "tamil nadu", 656565);
		Customer customer = new Customer(62,"syeddd"," syeddd@gmail.com","9040380958","2/4/1998",address);
		Product product = new Product(1,"Nike Airforce", " Shoes", " Sports shoes", " Nike", " white",
				 5, 4000, 10,  3000, true, expiryDate,1,"shoe image","Nike Airforce", 2, 3000, 6000);
		Payment payment = new Payment(25, "Debit", " Success", " Syed Samsudeen", 26, " 6321987425898521", expiryDate, 258);
		Order orderTemp = new Order(1, 8000, "25/3/2021", customer, product, payment);
		
		assertEquals(orderTemp.getAmount(), service.addOrder(orderTemp).getAmount());
	}

	@Disabled
	@Test
	void testRemoveOrder() {
		try {
			service.removeOrder(22);
		} catch (OrderServiceException exception) {
			assertEquals("OrderId does not exist to delete", exception.getMessage());
		}

	}

	@Disabled
	@Test
	void testRemoveOrder1() {
		assertEquals(service.getOrderDetails(122).getAmount(), service.removeOrder(122).getAmount());

	}

	@Disabled
	@Test
	void testUpdateOrder() {
		LocalDate expiryDate = LocalDate.parse("2025-05-25");
		Address address = new Address(63,"3", "7th street","porur", "chennai", "tamil nadu", 656565);
		Customer customer = new Customer(62,"syeddd"," syeddd@gmail.com","9040380958","2/4/1998",address);
		Product product = new Product(1,"Nike Airforce", " Shoes", " Sports shoes", " Nike", " white",
				 5, 4000, 10,  3000, true, expiryDate,1,"shoe image","Nike Airforce", 2, 3000, 6000);
		Payment payment = new Payment(25, "Debit", " Success", " Syed Samsudeen", 26, " 6321987425898521", expiryDate, 258);
		Order orderTemp = new Order(122, 9000, "25/3/2021", customer, product, payment);
		long OrderId = orderTemp.getOrderId();
		
		assertEquals(orderTemp.getAmount(), service.updateOrder(OrderId, orderTemp).getAmount());

	}

	@Disabled
	@Test
	void testUpdateOrder2() {
		LocalDate expiryDate = LocalDate.parse("2025-05-25");
		Address address = new Address(63,"3", "7th street","porur", "chennai", "tamil nadu", 656565);
		Customer customer = new Customer(62,"syeddd"," syeddd@gmail.com","9040380958","2/4/1998",address);
		Product product = new Product(1,"Nike Airforce", " Shoes", " Sports shoes", " Nike", " white",
				 5, 4000, 10,  3000, true, expiryDate,1,"shoe image","Nike Airforce", 2, 3000, 6000);
		Payment payment = new Payment(25, "Debit", " Success", " Syed Samsudeen", 26, " 6321987425898521", expiryDate, 258);
		Order orderTemp = new Order(1, 8000, "25/3/2021", customer, product, payment);
		long OrderId = orderTemp.getOrderId();
		try {
			service.updateOrder(OrderId, orderTemp);
		} catch (OrderServiceException exception) {
			assertEquals("OrderId not found", exception.getMessage());
		}

	}

	@Disabled
	@Test
	void testGetOrderDetails() {
		OrderDTO order = service.getOrderDetails(75);
		assertEquals(8000, order.getAmount());

	}

	@Disabled
	@Test
	void testGetOrderDetails2() {
		try {
			service.getOrderDetails(75);
		} catch (OrderServiceException exception) {
			assertEquals("OrderId does not exist", exception.getMessage());
		}
	}

	@Disabled
	@Test
	void testGetAllOrderDetails() {
		OrderDTO order1 = service.getOrderDetails(121);
        OrderDTO order2 = service.getOrderDetails(122);
		Order order3 = OrderUtil.convertToorder(order1);
        Order order4 = OrderUtil.convertToorder(order2);
		list.add(order3);
		list.add(order4);

		assertNotNull(list);
	}

}
