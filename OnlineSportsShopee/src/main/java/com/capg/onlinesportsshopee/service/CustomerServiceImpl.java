package com.capg.onlinesportsshopee.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.onlinesportsshopee.bean.Customer;
import com.capg.onlinesportsshopee.exceptions.CustomerServiceException;
import com.capg.onlinesportsshopee.model.CustomerDTO;
import com.capg.onlinesportsshopee.repo.ICustomerRepository;
import com.capg.onlinesportsshopee.util.CustomerUtil;

@Service
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	ICustomerRepository customerRepo;

	@Override
	public CustomerDTO addCustomer(Customer customer) throws CustomerServiceException 
	{
		Optional<Customer> addCustomertemp = customerRepo.findById(customer.getUserId());
		if (addCustomertemp.isEmpty()){
			Customer addCustomer = customerRepo.save(customer);
			return CustomerUtil.convertToCustomerDto(addCustomer);
		}
		else
		{
			throw new CustomerServiceException("Customer already exists");
		}
		
	}
	

	@Override
	public CustomerDTO removeCustomer(long userId) throws CustomerServiceException
	{

		Optional<Customer> customerTemp = customerRepo.findById(userId);
		if(customerTemp.isEmpty())
		{
			throw new CustomerServiceException("Customer does not exist");
		}
		else
		{
			customerRepo.deleteById(userId);
			return CustomerUtil.convertToCustomerDto(customerTemp.get());
		}
		
	}

	@Override
	public CustomerDTO updateCustomer(Customer customer) throws CustomerServiceException
	{
		Optional<Customer> updateCustomerTemp = customerRepo.findById(customer.getUserId());
		if(updateCustomerTemp.isEmpty()) 
		{
			throw new CustomerServiceException("Customer not found");
		}
		else
		{
			Customer updateCustomer = customerRepo.save(customer);
			return CustomerUtil.convertToCustomerDto(updateCustomer);	
		}
		
	}

	@Override
	public CustomerDTO getCustomer(long userId) throws CustomerServiceException 
	{
		Optional<Customer> getCustomerTemp = customerRepo.findById(userId);
		if(getCustomerTemp.isEmpty())
		{
			throw new CustomerServiceException("Customer does not exist");
		}
		else
		{
			Customer getCustomer = customerRepo.findById(userId).orElse(null);
			return CustomerUtil.convertToCustomerDto(getCustomer);
			
		}
		
	}

	@Override
	public List<CustomerDTO> getAllCustomers() throws CustomerServiceException {
		List<Customer> getCustomer = new ArrayList<Customer>();
		getCustomer = customerRepo.findAll();
		if(getCustomer.isEmpty())
		{
			throw new CustomerServiceException("Customers not found");
		}
		else
		{
			return CustomerUtil.convertToCustomerDtoList(getCustomer);
		}

	}

	public static boolean checkName(Customer customer) {
		boolean flag = true;
		if (customer.getName().length() < 3 || customer.getName().length() > 20 || customer.getName().isEmpty()) {
			flag = false;
		}
		return flag;
	}

	public static boolean checkContactNo(Customer customer) {
		boolean flag = true;
		if (customer.getContactNo().length() != 10 || customer.getContactNo().isEmpty()
				|| !(Pattern.matches("^[0-9]$", customer.getContactNo()))) {
			flag = false;
		}
		return flag;
	}

	public static boolean checkEmail(Customer customer) {
		boolean flag = true;
		if (customer.getEmail().length() < 8 || customer.getEmail().length() > 30
				|| customer.getEmail().isEmpty()
				|| !(Pattern.matches("^[A-Za-z0-9]+@[A-Za-z0-9.]$", customer.getEmail()))) {
			flag = false;
		}
		return flag;
	}

}
