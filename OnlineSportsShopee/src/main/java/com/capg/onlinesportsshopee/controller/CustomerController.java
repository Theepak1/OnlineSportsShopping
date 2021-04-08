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
import com.capg.onlinesportsshopee.bean.Customer;
import com.capg.onlinesportsshopee.model.CustomerDTO;
import com.capg.onlinesportsshopee.service.ICustomerService;
import com.capg.onlinesportsshopee.exceptions.CustomerServiceException;
/*
 * Author : Theepak Prakash P
 * Version : 1.0
 * Date : 07-04-2021
 * Description : This is  Customer Controller 
*/
@RestController
@RequestMapping("/api/oss")
public class CustomerController {

	@Autowired
	private ICustomerService customerService;

	@PostMapping("/addcustomer")
	public ResponseEntity<CustomerDTO> addCustomer(@RequestBody Customer customer) {
		CustomerDTO resultcustomer = customerService.addCustomer(customer);
		return new ResponseEntity<CustomerDTO>(resultcustomer, HttpStatus.OK);

	}

	@DeleteMapping("/deletecustomer/{id}")
	public ResponseEntity<CustomerDTO> deleteCustomer(@PathVariable long id) throws CustomerServiceException {
		CustomerDTO resultcustomer = customerService.removeCustomer(id);
		return new ResponseEntity<CustomerDTO>(resultcustomer, HttpStatus.OK);

	}

	@PutMapping("/updatecustomer")
	public ResponseEntity<CustomerDTO> updateCustomer(@RequestBody Customer customer) {
		CustomerDTO resultCustomer = customerService.updateCustomer(customer);
		return new ResponseEntity<CustomerDTO>(resultCustomer, HttpStatus.OK);
	}

	@GetMapping("/getcustomer/{id}")
	public ResponseEntity<CustomerDTO> getCustomer(@PathVariable long id) throws CustomerServiceException {
		CustomerDTO resultCustomer = customerService.getCustomer(id);
		return new ResponseEntity<CustomerDTO>(resultCustomer, HttpStatus.OK);
	}

	@GetMapping("/getallcustomers")
	public ResponseEntity<List<CustomerDTO>> getAllCustomers() {
		List<CustomerDTO> resultCustomer = customerService.getAllCustomers();
		return new ResponseEntity<List<CustomerDTO>>(resultCustomer, HttpStatus.OK);
	}
}