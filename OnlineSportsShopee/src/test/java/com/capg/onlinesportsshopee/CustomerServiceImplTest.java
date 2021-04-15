package com.capg.onlinesportsshopee;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.capg.onlinesportsshopee.bean.Customer;
import com.capg.onlinesportsshopee.exceptions.CustomerServiceException;
import com.capg.onlinesportsshopee.model.CustomerDTO;
import com.capg.onlinesportsshopee.service.CustomerServiceImpl;


/*
 * Author : THEEPAK PRAKASH P
 * Version : 1.0
 * Date : 07-04-2021
 * Description : This is Customer Service Implementation Test
*/
@SpringBootTest
public class CustomerServiceImplTest {

	@Autowired
	private CustomerServiceImpl service;

	final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

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
		LOGGER.info("Add customer Tested");

	}

	@Disabled
	@Test
	void testAddCustomer2() {

		Customer customer = new Customer("theepakrraj", "theepakrajf@gmail.com", "8131121212", "2/2/1999", "2", "19th",
				"porrur", "selam", "tamil nadu", 602032);

		assertEquals(customer.getName(), service.addCustomer(customer).getName());
		LOGGER.info("Add customer Tested");
	}

	@Disabled
	@Test
	void testRemoveCustomer() {
		try {
			service.removeCustomer(2);
		} catch (CustomerServiceException exception) {
			assertEquals("Customer does not exist", exception.getMessage());
		}
		LOGGER.info("Remove customer Tested");

	}

	@Disabled
	@Test
	void testRemoveCustomer1() {
		assertEquals(service.getCustomer(189).getContactNo(), service.removeCustomer(189).getContactNo());
		LOGGER.info("Remove customer Tested");
	}

	@Disabled
	@Test
	void testUpdateCustomer() {
		Customer customer = new Customer(170, "theepakenewone", "theepakee@gmail.com", "9321121212", "2/2/1999", "2",
				"19th", "porrur", "selam", "tamil nadu", 602032);

		assertEquals("theepakenewone", service.updateCustomer(customer).getName());
		LOGGER.info("Update customer Tested");
	}

	@Disabled
	@Test
	void testUpdateCustomer2() {

		Customer customer = new Customer(2, "theepakenew1", "theepak3e@gmail.com", "9111121212", "2/2/1999", "2",
				"19th", "porrur", "selam", "tamil nadu", 602032);

		try {
			service.updateCustomer(customer);
		} catch (CustomerServiceException exception) {
			assertEquals("Customer not found or invalid inputs", exception.getMessage());
		}
		LOGGER.info("Update customer Tested");
	}

	@Disabled
	@Test
	void testFindCustomerById() {
		CustomerDTO customer = service.getCustomer(180);
		assertEquals("theepak", customer.getName());
		LOGGER.info("Get customer by id  Tested");
	}

	@Disabled
	@Test
	void testGetContactNo() {
		CustomerDTO customer = service.getCustomer(180);
		assertEquals("9080380958", customer.getContactNo());
		LOGGER.info("Get customer by Contact number  Tested");
	}

	@Disabled
	@Test
	void testGetDateOfBirth() {
		CustomerDTO customer = service.getCustomer(180);
		assertEquals("2/4/1998", customer.getDob());
		LOGGER.info("Get customer by Date of birth Tested");
	}

	@Disabled
	@Test
	void testGetEmail() {
		CustomerDTO customer = service.getCustomer(180);
		assertEquals("theepak@gmail.com", customer.getEmail());
		LOGGER.info("Get customer by id  Tested");
	}

	@Disabled
	@Test
	void testValidateCheckName() {
		Customer customer = new Customer("th", "theepak3e@gmail.com", "9111121212", "2/2/1999", "2", "19th", "porrur",
				"selam", "tamil nadu", 602032);
		assertEquals(false, CustomerServiceImpl.checkName(customer));
		LOGGER.info("Validate by name Tested");

	}

	@Disabled
	@Test
	void testValidateCheckContactNo() {

		Customer customer = new Customer("theepak", "theepak3e@gmail.com", "911", "2/2/1999", "2", "19th", "porrur",
				"selam", "tamil nadu", 602032);
		assertEquals(false, CustomerServiceImpl.checkContactNo(customer));
		LOGGER.info("Validate by Contact number Tested");

	}

	@Disabled
	@Test
	void testValidateCheckEmail() {

		Customer customer = new Customer("theepak", "th@12", "911", "2/2/1999", "2", "19th", "porrur", "selam",
				"tamil nadu", 602032);
		assertEquals(false, CustomerServiceImpl.checkEmail(customer));
		LOGGER.info("Validate by Email Tested");

	}

}

