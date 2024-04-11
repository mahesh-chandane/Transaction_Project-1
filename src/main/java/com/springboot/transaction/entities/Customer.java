package com.springboot.transaction.entities;

import java.util.List ;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Customer 
{ 
	
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int customerId;
  private String customerName;
  @Column(unique = true)
  private long customerMobile;
  
  @OneToMany    //(mappedBy = "customer", cascade = CascadeType.ALL, fetch=FetchType.LAZY)    //mappedby  mean perform operation on that object 
  private List<Transaction> Transactions; 
  
  
public Customer() {
	super();
	// TODO Auto-generated constructor stub
}
public Customer(int customerId, String customerName, long customerMobile) {
	super();
	this.customerId = customerId;
	this.customerName = customerName;
	this.customerMobile = customerMobile;
}
public int getCustomerId() {
	return customerId;
}
public void setCustomerId(int customerId) {
	this.customerId = customerId;
}
public String getCustomerName() {
	return customerName;
}
public void setCustomerName(String customerName) {
	this.customerName = customerName;
}
public long getCustomerMobile() {
	return customerMobile;
}
public void setCustomerMobile(long customerMobile) {
	this.customerMobile = customerMobile;
}
  
  
  
  
}
