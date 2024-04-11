package com.springboot.transaction.service.Impl;

import java.util.List   ;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.transaction.exceptions.*;

import com.springboot.transaction.dto.CustomerDto;
import com.springboot.transaction.entities.Customer;
import com.springboot.transaction.repository.CustomerRepo;
import com.springboot.transaction.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService 
{
	 @Autowired
  private CustomerRepo customerRepo;
  
  @Autowired
	private  ModelMapper modelMapper;
	

@Override
public CustomerDto createCustomer(CustomerDto customerDto) 
{
	Customer customer=this.dtoToCustomer(customerDto);
 	Customer savedCustomer=this.customerRepo.save(customer);	
   return this.customerToDto(savedCustomer);
}

@Override
public CustomerDto updateCustomer(CustomerDto customerDto, Integer customerId) {
	Customer customer=this.customerRepo.findById(customerId).orElseThrow(() -> new  ResourceNotFoundException("User","Id", customerId));
	customer.setCustomerName(customerDto.getCustomerName());
	customer.setCustomerMobile(customerDto.getCustomerMobile());
	
	Customer updatedCustomer=this.customerRepo.save(customer);
	CustomerDto customerDto1= this.customerToDto(updatedCustomer);
	return customerDto1;

}


@Override
public CustomerDto getCustomerById(Integer customerId) {
	Customer customer=this.customerRepo.findById(customerId).orElseThrow(() ->new ResourceNotFoundException("customer","Id", customerId) );
	return this.customerToDto(customer);
}



@Override
public List<CustomerDto> getAllCustomer() {
	List<Customer>customers=this.customerRepo.findAll();
	List<CustomerDto>customerDtos=customers.stream().map(Customer->this.customerToDto(Customer)).collect(Collectors.toList());
	return customerDtos;
}

@Override
public Customer deleteCustomer(Integer customerId) 
{
	Customer customer=this.customerRepo.findById(customerId).orElseThrow(() ->new ResourceNotFoundException("User","Id", customerId) );
	this.customerRepo.delete(customer);
	return customer;
}

//@Override
//public void deleteCustomer1(Integer customerId) 
//{
//	Customer customer=this.customerRepo.findById(customerId).orElseThrow(() ->new ResourceNotFoundException("User","Id", customerId) );
//	this.customerRepo.delete(customer);
//}

public Customer dtoToCustomer(CustomerDto customerDto )
{
	Customer customer=this.modelMapper.map(customerDto, Customer.class);
	return customer;
}

public CustomerDto customerToDto(Customer customer)
{
	CustomerDto customerDto=this.modelMapper.map(customer, CustomerDto.class);
	return customerDto;
}



}
