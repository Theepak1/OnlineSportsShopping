package com.capg.onlinesportsshopee.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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
		Optional<Customer> addCustomerTemp = customerRepo.findById(customer.getUserId());
		if (addCustomerTemp.isEmpty() && CustomerServiceImpl.checkName(customer) && CustomerServiceImpl.checkContactNo(customer) && CustomerServiceImpl.checkEmail(customer)){
			Customer addCustomer = customerRepo.save(customer);
			return CustomerUtil.convertToCustomerDto(addCustomer);
		}
		else
		{
			throw new CustomerServiceException("Customer already exists or invalid inputs");
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
			if(customerTemp.isPresent())
			{
				return CustomerUtil.convertToCustomerDto(customerTemp.get());
			}
			else
			{
				throw new CustomerServiceException("Customer is not present");
			}
			
		}
		
	}

	@Override
	public CustomerDTO updateCustomer(Customer customer) throws CustomerServiceException
	{
		Optional<Customer> updateCustomerTemp = customerRepo.findById(customer.getUserId());
		if(updateCustomerTemp.isEmpty() && CustomerServiceImpl.checkName(customer) && CustomerServiceImpl.checkContactNo(customer) && CustomerServiceImpl.checkEmail(customer)) 
		{
			throw new CustomerServiceException("Customer not found or invalid inputs");
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
		if (customer.getContactNo().length() != 10 || customer.getContactNo().isEmpty()) {
			flag = false;
		}
		return flag;
	}

	public static boolean checkEmail(Customer customer) {
		boolean flag = true;
		if (customer.getEmail().length() < 8 || customer.getEmail().length() > 30
				|| customer.getEmail().isEmpty()) {
			flag = false;
		}
		return flag;
	}

}