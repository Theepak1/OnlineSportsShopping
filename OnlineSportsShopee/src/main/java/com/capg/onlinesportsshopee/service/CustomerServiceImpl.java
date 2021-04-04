package com.capg.onlinesportsshopee.service;

import java.util.ArrayList;



import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.onlinesportsshopee.bean.Customer;
import com.capg.onlinesportsshopee.model.CustomerDTO;
import com.capg.onlinesportsshopee.repo.ICustomerRepository;
import com.capg.onlinesportsshopee.util.CustomerUtil;


@Service
public class CustomerServiceImpl implements ICustomerService {
	
	@Autowired
	ICustomerRepository customerRepo;
	
	@Override
	public CustomerDTO addCustomer(Customer customer) 
	{
		Customer addCustomer=new Customer();
		addCustomer=customerRepo.save(customer);
		return CustomerUtil.convertToCustomerDto(addCustomer);
	}

	@Override
	public CustomerDTO removeCustomer(long userId) {
		
		Customer customertemp=new Customer();
		customertemp=customerRepo.getOne(userId);
		customerRepo.deleteById(userId);
		return CustomerUtil.convertToCustomerDto(customertemp);
	}

	@Override
	public CustomerDTO updateCustomer(Customer customer) {
		Customer updateCustomer=new Customer();
		updateCustomer=customerRepo.save(customer);
		return CustomerUtil.convertToCustomerDto(updateCustomer);
	}

	@Override
	public CustomerDTO getCustomer(long userId) {
		Customer getCustomer=new Customer();
		getCustomer=customerRepo.findById(userId).orElse(null);
		return CustomerUtil.convertToCustomerDto(getCustomer);
	}

	@Override
	public List<CustomerDTO> getAllCustomers() {
		List<Customer> getCustomer=new ArrayList<Customer>();
		getCustomer=customerRepo.findAll();
		return CustomerUtil.convertToCustomerDtoList(getCustomer);
		
	}
	
	public static boolean checkName(Customer customer)
	{
		boolean flag=true;
		if(customer.getName()==null || customer.getName().length()<3 || customer.getName().length()>20 || customer.getName().isEmpty())
		{
			flag=false;
		}
		return flag;
	}
	
	public static boolean checkContactNo(Customer customer)
	{
		boolean flag=true;
		if(customer.getContactNo()==null || customer.getName().length()!=10 || customer.getName().isEmpty()
				|| !(Pattern.matches("^[0-9]$",customer.getContactNo())))
		{
			flag=false;
		}
		return flag;
	}
	
	public static boolean checkEmail(Customer customer)
	{
		boolean flag=true;
		if(customer.getEmail()==null || customer.getEmail().length()<8 ||  customer.getEmail().length()>30 ||
				customer.getEmail().isEmpty() || !(Pattern.matches("^[A-Za-z0-9]+@[A-Za-z0-9.]$",customer.getEmail())))
		{
			flag=false;
		}
		return flag;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
