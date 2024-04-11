package com.springboot.transaction.dto;


public class CustomerDto {

	  private int customerId;

	private String customerName;
	private long customerMobile;

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

	public CustomerDto() {
		super();
	}

	public CustomerDto(int customerId, String customerName, long customerMobile) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerMobile = customerMobile;
	}


	  
	  
	  
}
