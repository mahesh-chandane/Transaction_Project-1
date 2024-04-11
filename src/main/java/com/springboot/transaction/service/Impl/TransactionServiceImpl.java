package com.springboot.transaction.service.Impl;

import java.util.List   ;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.springboot.transaction.exceptions.*;
import com.springboot.transaction.dto.TransactionDto;
import com.springboot.transaction.entities.Customer;
import com.springboot.transaction.entities.Product;
import com.springboot.transaction.entities.Transaction;
import com.springboot.transaction.repository.CustomerRepo;
import com.springboot.transaction.repository.ProductRepo;
import com.springboot.transaction.repository.TransactionRepo;
import com.springboot.transaction.service.TransactionService;
@Service
public class TransactionServiceImpl implements TransactionService {

	
	@Autowired
	private TransactionRepo transactionRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private CustomerRepo customerRepo;
	
	@Autowired
	private ProductRepo productRepo;
	
	@Override
	public TransactionDto createTransaction(TransactionDto transactionDto, Integer customerId, Integer productId) {
	Customer customer=this.customerRepo.findById(customerId).orElseThrow(()->new ResourceNotFoundException("customer"," customer id", customerId));
	Product product=this.productRepo.findById(productId).orElseThrow(()->new ResourceNotFoundException("product"," product Id", productId));

	Transaction transaction=this.modelMapper.map(transactionDto, Transaction.class);
	transaction.setCustomer(customer);
//	transaction.setProduct(product);
   
	Transaction newTransaction=this.transactionRepo.save(transaction);
   return this.modelMapper.map(newTransaction, TransactionDto.class);
  	
	}

	@Override
	public TransactionDto updatedTransaction(TransactionDto transactionDto, Integer transactionId) {
		Transaction transaction=this.transactionRepo.findById(transactionId).orElseThrow(()->new ResourceNotFoundException("Transaction ", "transaction Id", transactionId));	
		transaction.setTransactionMode(transactionDto.getTransactionMode());
		
//		post.setUser(postDto.getUser());
//		post.setCategory(postDto.getCategory());
		Transaction updatdTransaction=this.transactionRepo.save(transaction);
		
		return this.modelMapper.map(updatdTransaction, TransactionDto.class);
	}


	@Override
	public List<TransactionDto> getAllTransaction() {
   
	List<Transaction>allTransactions=	this.transactionRepo.findAll();
	List<TransactionDto>transactionDtos= allTransactions.stream().map((transaction)-> this.modelMapper.map(transaction,TransactionDto.class))
			.collect(Collectors.toList());
		return transactionDtos;
	}
	
	@Override
	public TransactionDto getTransactionById(Integer transactionId) {
		
		Transaction transaction=this.transactionRepo.findById(transactionId)
		.orElseThrow(()->new ResourceNotFoundException("Transaction ", "transaction Id", transactionId));	
		
		return this.modelMapper.map(transaction, TransactionDto.class);
	}
	
	@Override
	public void deleteTransaction(Integer transactionId) {

		Transaction transaction=this.transactionRepo.findById(transactionId).orElseThrow(()->new ResourceNotFoundException("Transaction ", "transaction Id", transactionId));	
	 this.transactionRepo.delete(transaction);	
	}

	@Override
	public List<TransactionDto> getPostsByCustomer(Integer customerId) {
		Customer customer=this.customerRepo.findById(customerId).orElseThrow(()->new ResourceNotFoundException("Customer", "customer id", customerId));
		List<Transaction>transactions= this.transactionRepo.findByCustomer(customer);
		List<TransactionDto>transactionDtos=  transactions.stream().map((transaction)-> this.modelMapper.map(transactions ,TransactionDto.class)).collect(Collectors.toList());
		return transactionDtos;
		}
	
	

	   @Override
	  public List<TransactionDto> getPostsByProduct(Integer productId) {
	    Product product=  this.productRepo.findById(productId).orElseThrow(()->new ResourceNotFoundException("Product", "product id", productId));
			List<Transaction>transactions= this.transactionRepo.findByProduct(product);
			List<TransactionDto>transactionDtos= transactions.stream().map((transaction)-> this.modelMapper.map(transaction,TransactionDto.class))
			.collect(Collectors.toList());
			
			return transactionDtos;
		}






	@Override
	public TransactionDto createAllTransaction(TransactionDto transactionDto, Integer customerId, Integer productId) {
		return null;
	}
	
	

	@Override
	public Transaction addTransaction(Transaction transactionDto) {
		
		return transactionRepo.save(transactionDto);
//		Customer customers=this.customerRepo.save(customer);
//		Product products=this.productRepo.save(product);
//
//		Transaction transaction=this.modelMapper.map(transactionDto, Transaction.class);
//		transaction.setCustomer(customers);
//		transaction.setProduct(products);
//	   
//		Transaction newTransaction=this.transactionRepo.save(transaction);
//	   return this.modelMapper.map(newTransaction, TransactionDto.class);
	  	
		
	}



	

	
	

}
