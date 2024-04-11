package com.springboot.transaction.controller;

import java.util.List;
import java.util.Map;

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

import com.springboot.transaction.dto.CustomerDto;
import com.springboot.transaction.entities.Customer;
import com.springboot.transaction.service.CustomerService;

@RestController
@RequestMapping("/api/customers/")
public class CustomerController 
{
 @Autowired
 private CustomerService customerService;
 
 
 @PostMapping("save")
 public ResponseEntity<CustomerDto>createCustomer(@RequestBody CustomerDto cust)
 {
	 CustomerDto createCustomerDto =this.customerService.createCustomer(cust);
	  return new ResponseEntity<>(createCustomerDto ,HttpStatus.CREATED);
 }
 
 @PutMapping("updateById/{customerId}")
 public ResponseEntity<CustomerDto> updateUser(@RequestBody CustomerDto customerDto,@PathVariable Integer customerId)
 {
	 CustomerDto updateUser=this.customerService.updateCustomer(customerDto, customerId);
	  return ResponseEntity.ok(updateUser);
 }
 
 @GetMapping("getAll")
	public ResponseEntity<List<CustomerDto>> getAllCustomer() {
		return ResponseEntity.ok(this.customerService.getAllCustomer());
	 		
  }
 
 @GetMapping("getById/{customerId}")
	public ResponseEntity<CustomerDto> getUserById(@PathVariable Integer customerId) {
	  return ResponseEntity.ok(customerService.getCustomerById(customerId));
		
 }
 
 @DeleteMapping("deleteByIds/{customerId}") 
 public ResponseEntity<?> deleteUser1(@PathVariable Integer customerId)
{
      this.customerService.deleteCustomer(customerId);
	
	return new ResponseEntity(Map.of("message", "customer deleted successfully"),HttpStatus.OK);   
	
}

 
 
}
