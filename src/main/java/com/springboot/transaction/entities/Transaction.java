package com.springboot.transaction.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Transaction {

	@Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private int transactionId;
	  private String transactionMode;
	
	   @ManyToOne
	  private  Customer customer;   //user

	   @ManyToMany
		  private List<Product> product;  //category
		  
	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

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

	public Transaction(int transactionId, String transactionMode,  Customer customer,List<Product> product) {
		super();
		this.transactionId = transactionId;
		this.transactionMode = transactionMode;
		this.customer = customer;
		this.product = product;
	
	}

	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}

	   
	   
	   
	  
}
