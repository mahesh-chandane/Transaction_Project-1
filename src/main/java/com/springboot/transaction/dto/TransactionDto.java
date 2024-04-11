package com.springboot.transaction.dto;

import java.util.List;

import com.springboot.transaction.entities.Customer;
import com.springboot.transaction.entities.Product;

public class TransactionDto 
{
	private String transactionMode;
	 private  Customer customer;
	 private List<Product> product;
 	 
	public String getTransactionMode() {
		return transactionMode;
	}
	public void setTransactionMode(String transactionMode) {
		this.transactionMode = transactionMode;
	}
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public List<Product> getProduct() {
		return product;
	}
	public void setProduct(List<Product> product) {
		this.product = product;
	}
	public TransactionDto(String transactionMode,  Customer customer ,List<Product> product) {
		super();
		this.transactionMode = transactionMode;
		this.customer = customer;
		this.product = product;
	}
	public TransactionDto() {
		super();
		// TODO Auto-generated constructor stub
	}
 	  
 	  
 	  
 	  
 	  
 	  
}
