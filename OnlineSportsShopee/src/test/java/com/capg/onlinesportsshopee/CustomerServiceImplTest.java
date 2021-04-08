package com.capg.onlinesportsshopee;

import static org.junit.jupiter.api.Assertions.assertEquals;



import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capg.onlinesportsshopee.bean.Customer;

import com.capg.onlinesportsshopee.exceptions.CustomerServiceException;

import com.capg.onlinesportsshopee.model.CustomerDTO;

import com.capg.onlinesportsshopee.service.CustomerServiceImpl;

@SpringBootTest
public class CustomerServiceImplTest {

	@Autowired
	private CustomerServiceImpl service;

	@Disabled
	@Test
	void testAddCustomer() {

		Customer customer = new Customer("theepake1", "theepak1e@gmail.com", "9011", "2/2/1999", "2", "19th", "porrur",
				"selam", "tamil nadu", 602032);
		try {
			service.addCustomer(customer);
		} catch (CustomerServiceException exception) {
			assertEquals("Customer already exists or invalid inputs", exception.getMessage());
		}

	}

	@Disabled
	@Test
	void testAddCustomer2() {

		Customer customer = new Customer("theepake3", "theepak3e@gmail.com", "9111121212", "2/2/1999", "2", "19th",
				"porrur", "selam", "tamil nadu", 602032);

		assertEquals(customer.getName(), service.addCustomer(customer).getName());

	}

	@Disabled
	@Test
	void testRemoveCustomer() {
		try {
			service.removeCustomer(0);
		} catch (CustomerServiceException exception) {
			assertEquals("Customer does not exist", exception.getMessage());
		}

	}

	@Disabled
	@Test
	void testRemoveCustomer1() {// give number present in table
		assertEquals(service.getCustomer(132).getContactNo(), service.removeCustomer(132).getContactNo());

	}

	@Disabled
	@Test
	void testUpdatePayment() {// give number present in table and make some changes
		Customer customer = new Customer(164, "theepakenew1", "theepak3e@gmail.com", "9111121212", "2/2/1999", "2",
				"19th", "porrur", "selam", "tamil nadu", 602032);

		assertEquals("theepakenew", service.updateCustomer(customer).getName());

	}

	@Disabled
	@Test
	void testUpdateCustomer2() {// give number not in table

		Customer customer = new Customer(2, "theepakenew1", "theepak3e@gmail.com", "9111121212", "2/2/1999", "2",
				"19th", "porrur", "selam", "tamil nadu", 602032);

		try {
			service.updateCustomer(customer);
		} catch (CustomerServiceException exception) {
			assertEquals("Customer not found or invalid inputs", exception.getMessage());
		}

	}

	@Test
	void testFindEmployeeById() // give number present in data base also data
	{
		CustomerDTO customer = service.getCustomer(116);
		assertEquals("syeddd", customer.getName());
	}

	@Test
	void testGetContactNo() {
		CustomerDTO customer = service.getCustomer(116);
		assertEquals("9040380958", customer.getContactNo());
	}

	@Test
	void testGetDateOfBirth() {
		CustomerDTO customer = service.getCustomer(116);
		assertEquals("2/4/1998", customer.getDob());
	}

	@Test
	void testGetEmail() {
		CustomerDTO customer = service.getCustomer(116);
		assertEquals("syeddd@gmail.com", customer.getEmail());
	}

	

	
	//@Disabled
	@Test
	void testValidateCheckName() {

		
		Customer customer = new Customer("th", "theepak3e@gmail.com", "9111121212", "2/2/1999", "2",
				"19th", "porrur", "selam", "tamil nadu", 602032);
		assertEquals(false, service.checkName(customer));

	}

	@Test
	void testValidateCheckContactNo() {

		
		Customer customer = new Customer("theepak", "theepak3e@gmail.com", "911", "2/2/1999", "2",
				"19th", "porrur", "selam", "tamil nadu", 602032);
		assertEquals(false, service.checkContactNo(customer));

	}
	
	
	@Test
	void testValidateCheckEmail() {

		
		Customer customer = new Customer("theepak", "th@12", "911", "2/2/1999", "2",
				"19th", "porrur", "selam", "tamil nadu", 602032);
		assertEquals(false, service.checkEmail(customer));

	}
	
	
	
	
	

}
