package com.springboot.transaction.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.transaction.entities.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer>
{
  
}
