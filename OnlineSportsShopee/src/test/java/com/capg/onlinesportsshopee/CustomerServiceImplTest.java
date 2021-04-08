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

	
	@Test
	void testAddCustomer2() {// make changes

		Customer customer = new Customer("theepakr5", "theepak2f@gmail.com", "9231121212", "2/2/1999", "2", "19th",
				"porrur", "selam", "tamil nadu", 602032);

		assertEquals(customer.getName(), service.addCustomer(customer).getName());

	}

	
	@Test
	void testRemoveCustomer() {
		try {
			service.removeCustomer(0);
		} catch (CustomerServiceException exception) {
			assertEquals("Customer does not exist", exception.getMessage());
		}

	}

	
	@Test
	void testRemoveCustomer1() {// give number present in table that is not used in get
		assertEquals(service.getCustomer(185).getContactNo(), service.removeCustomer(185).getContactNo());

	}

	
	@Test
	void testUpdateCustomer() {// make changes
		Customer customer = new Customer(170, "theepakenew6", "theepak4e@gmail.com", "9311121212", "2/2/1999", "2",
				"19th", "porrur", "selam", "tamil nadu", 602032);

		assertEquals("theepakenew6", service.updateCustomer(customer).getName());

	}

	
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
		CustomerDTO customer = service.getCustomer(180);
		assertEquals("theepak", customer.getName());
	}

	
	@Test
	void testGetContactNo() {
		CustomerDTO customer = service.getCustomer(180);
		assertEquals("9080380958", customer.getContactNo());
	}

	
	@Test
	void testGetDateOfBirth() {
		CustomerDTO customer = service.getCustomer(180);
		assertEquals("2/4/1998", customer.getDob());
	}

	
	@Test
	void testGetEmail() {
		CustomerDTO customer = service.getCustomer(180);
		assertEquals("theepak@gmail.com", customer.getEmail());
	}

	
	@Test
	void testValidateCheckName() {
		Customer customer = new Customer("th", "theepak3e@gmail.com", "9111121212", "2/2/1999", "2", "19th", "porrur",
				"selam", "tamil nadu", 602032);
		assertEquals(false, CustomerServiceImpl.checkName(customer));

	}


	@Test
	void testValidateCheckContactNo() {

		Customer customer = new Customer("theepak", "theepak3e@gmail.com", "911", "2/2/1999", "2", "19th", "porrur",
				"selam", "tamil nadu", 602032);
		assertEquals(false, CustomerServiceImpl.checkContactNo(customer));

	}

	
	@Test
	void testValidateCheckEmail() {

		Customer customer = new Customer("theepak", "th@12", "911", "2/2/1999", "2", "19th", "porrur", "selam",
				"tamil nadu", 602032);
		assertEquals(false, CustomerServiceImpl.checkEmail(customer));

	}

}
