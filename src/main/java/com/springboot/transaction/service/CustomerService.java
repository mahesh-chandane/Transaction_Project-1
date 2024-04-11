package com.springboot.transaction.service;

import java.util.List;

import com.springboot.transaction.dto.CustomerDto;
import com.springboot.transaction.entities.Customer;

public interface CustomerService 
{
	CustomerDto  createCustomer(CustomerDto customer);
	CustomerDto getCustomerById(Integer customerId);
	  List<CustomerDto> getAllCustomer();
	  Customer deleteCustomer(Integer customerId);
	  CustomerDto updateCustomer(CustomerDto customer, Integer customerId);
	  
//	  public void deleteCustomer1(Integer customerId) ;

	   
}
