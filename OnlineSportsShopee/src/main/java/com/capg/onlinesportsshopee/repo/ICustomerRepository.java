package com.capg.onlinesportsshopee.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.onlinesportsshopee.bean.Customer;



@Repository
public interface ICustomerRepository extends JpaRepository<Customer,Long>{
	
	
	
	
	
	
	/*
	 * public Customer addCustomer(Customer customer); public Customer
	 * removeCustomer(long custId); public Customer updateCustomer(long custId,
	 * Customer customer); public Customer getCustomer(long custId); public
	 * List<Customer> getAllCustomers();
	 */ 
}