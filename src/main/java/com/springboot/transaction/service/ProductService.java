package com.springboot.transaction.service;

import java.util.List;

import com.springboot.transaction.dto.ProductDto;

public interface ProductService 
{
   
	
	ProductDto  createProduct(ProductDto product);
	ProductDto getProductById(Integer productId);
	  List<ProductDto> getAllProduct();
	  void deleteProduct(Integer productId);
	  ProductDto updateProduct(ProductDto product, Integer productId);
	  
	   
	
}
