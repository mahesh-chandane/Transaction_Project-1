package com.springboot.transaction.service.Impl;

import java.util.List ;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.transaction.exceptions.*;

import com.springboot.transaction.dto.ProductDto;
import com.springboot.transaction.entities.Product;
import com.springboot.transaction.exceptions.ResourceNotFoundException;
import com.springboot.transaction.repository.ProductRepo;
import com.springboot.transaction.service.ProductService;
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepo productRepo;
	
	
	 @Autowired
		private  ModelMapper modelMapper;
		
	

	@Override
	public ProductDto createProduct(ProductDto productDto) 
	{
		Product product=this.dtoToProduct(productDto);
		Product savedProduct=this.productRepo.save(product);	
	   return this.productToDto(savedProduct);
	}


	@Override
	public ProductDto getProductById(Integer productId) {
		Product product=this.productRepo.findById(productId).orElseThrow(() ->new ResourceNotFoundException("product","Id", productId) );

		return this.productToDto(product);
	}


@Override
public List<ProductDto> getAllProduct() {
	 List<Product>products=this.productRepo.findAll();
	List<ProductDto>productDto=products.stream().map(Product->this.productToDto(Product)).collect(Collectors.toList());
	return productDto;
}
	
	

	@Override
	public void deleteProduct(Integer productId) {
		Product product=this.productRepo.findById(productId).orElseThrow(() ->new ResourceNotFoundException("product","Id", productId) );
		this.productRepo.delete(product);
	}
	
	@Override
	public ProductDto updateProduct(ProductDto productDto, Integer  productId) {
		Product product=this.productRepo.findById(productId).orElseThrow(() -> new  ResourceNotFoundException("product","Id", productId));
		product.setProductName(productDto.getProductName());
		product.setProductPrice(productDto.getProductPrice());
		Product updatedProduct=this.productRepo.save(product);
		ProductDto productDto1= this.productToDto(updatedProduct);
		return productDto1;
	
	}
	
	public Product dtoToProduct(ProductDto productDto )
	{
		Product product=this.modelMapper.map(productDto, Product.class);
		return product;
		
	}

	public ProductDto productToDto(Product product)
	{
		ProductDto productDto=this.modelMapper.map(product, ProductDto.class);
		return productDto;

	}
	
	
	

}
