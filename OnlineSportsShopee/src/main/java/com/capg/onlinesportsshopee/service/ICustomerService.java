package com.capg.onlinesportsshopee.service;

import java.util.List;
import com.capg.onlinesportsshopee.bean.Customer;
import com.capg.onlinesportsshopee.model.CustomerDTO;


public interface ICustomerService {
	public CustomerDTO addCustomer(Customer customer);
	public CustomerDTO removeCustomer(long custId);
	public CustomerDTO updateCustomer(Customer customer);
	public CustomerDTO getCustomer(long custId);
	public List<CustomerDTO> getAllCustomers(); 
}
