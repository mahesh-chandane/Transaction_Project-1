
package com.springboot.transaction.controller;

import java.util.List ;
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

import com.springboot.transaction.dto.TransactionDto;
import com.springboot.transaction.entities.Transaction;
import com.springboot.transaction.service.TransactionService;

@RestController
@RequestMapping("/api/transactions/")
public class TransactionController
{
  @Autowired
  private TransactionService transactionService;
  
  
  @PostMapping("save")
  public ResponseEntity<Transaction> createPost(@RequestBody Transaction dto) {
	  Transaction transaction = transactionService.addTransaction(dto);
      return new ResponseEntity<>(transaction, HttpStatus.CREATED);
  }
  
  @PostMapping("/customer/{customerId}/product/[{productId}]/transactions")
  public ResponseEntity<TransactionDto> createTransaction(@RequestBody TransactionDto postDto, @RequestBody Integer customerId, @RequestBody Integer productId )
  {
	  TransactionDto createTransaction=this.transactionService.createTransaction(postDto, customerId, productId);
		return new ResponseEntity<TransactionDto>(createTransaction,HttpStatus.CREATED);
	  			
		
  }
  
  @GetMapping("/getAll")
  public ResponseEntity<List<TransactionDto> > getTransaction()
  {
	   List<TransactionDto> allTransaction= this.transactionService.getAllTransaction();
	   return new ResponseEntity<List<TransactionDto>>(allTransaction,HttpStatus.OK);
  }
  
  @GetMapping("/getById/{transactionId}")
  public ResponseEntity<TransactionDto > getPostById(@PathVariable Integer transactionId)
  {
	  TransactionDto transactionDto= this.transactionService.getTransactionById(transactionId);
	   return new ResponseEntity<TransactionDto>(transactionDto,HttpStatus.OK);
  }
  
  @PutMapping("/update/{transactionId}") 
  public ResponseEntity< TransactionDto> update(@RequestBody TransactionDto transactionDto ,  @PathVariable Integer transactionId)
{
	  TransactionDto updatedtransaction= this.transactionService.updatedTransaction(transactionDto,transactionId);
	
	  return new ResponseEntity<TransactionDto>(updatedtransaction, HttpStatus.OK);   
}

  @DeleteMapping("/delete/{transactionId}") 
  public ResponseEntity<?> deletePost(@PathVariable Integer transactionId)
{
       this.transactionService.deleteTransaction(transactionId);
	
	return new ResponseEntity(Map.of("message", "transaction deleted successfully"),HttpStatus.OK);   
}
  


  
  
}
