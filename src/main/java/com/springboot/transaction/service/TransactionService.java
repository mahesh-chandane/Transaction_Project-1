package com.springboot.transaction.service;

import java.util.List;

import com.springboot.transaction.dto.TransactionDto;
import com.springboot.transaction.entities.Customer;
import com.springboot.transaction.entities.Product;
import com.springboot.transaction.entities.Transaction;

public interface TransactionService 
{

	  public TransactionDto createTransaction(TransactionDto transactionDto, Integer customerId, Integer productId );    
	  public TransactionDto updatedTransaction(TransactionDto transactionDto , Integer TransactionId);
	  List<TransactionDto> getAllTransaction();
	  public TransactionDto getTransactionById(Integer TransactionId);
	  void deleteTransaction(Integer transactionId);
	 
	  // get all post by category
	  List<TransactionDto>getPostsByCustomer(Integer customerId);
	  
	  //get all post by user
	  List<TransactionDto>getPostsByProduct(Integer productId);

	  //it is example editing
	  public TransactionDto createAllTransaction(TransactionDto transactionDto, Integer customerId, Integer productId );    

	  
  public Transaction addTransaction(Transaction transactionDto );    

	  
}
