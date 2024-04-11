package com.springboot.transaction.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.transaction.entities.Product;

public interface ProductRepo  extends JpaRepository<Product, Integer>{
	

}
