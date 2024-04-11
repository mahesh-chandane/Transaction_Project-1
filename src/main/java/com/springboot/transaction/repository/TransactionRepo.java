package com.springboot.transaction.repository;

import java.util.List ;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.transaction.entities.Transaction;
import com.springboot.transaction.dto.TransactionDto;
import com.springboot.transaction.entities.Customer;

import com.springboot.transaction.entities.Product;

public interface TransactionRepo extends JpaRepository<Transaction, Integer>
{
	List<Transaction> findByCustomer(Customer customer);
	   
	   List<Transaction> findByProduct(Product product);

	TransactionDto save(TransactionDto transactionDto);
	   
}
