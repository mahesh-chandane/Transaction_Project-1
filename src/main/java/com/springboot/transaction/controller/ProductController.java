package com.springboot.transaction.controller;

import java.util.List;
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

import com.springboot.transaction.dto.ProductDto;
import com.springboot.transaction.service.ProductService;


@RestController
@RequestMapping("/api/products/")
public class ProductController 
{

	
	
	@Autowired
	 private ProductService productService;
	 
	 
	 @PostMapping("save")
	 public ResponseEntity<ProductDto>createProduct(@RequestBody ProductDto product1)
	 {
		 ProductDto createproductDto =this.productService.createProduct(product1);
		  return new ResponseEntity<>(createproductDto ,HttpStatus.CREATED);
	 }
	 
	 @PutMapping("updateById/{productId}")
	 public ResponseEntity<ProductDto> updateProduct(@RequestBody ProductDto productDto,@PathVariable Integer productId)
	 {
		 ProductDto updateProduct=this.productService.updateProduct(productDto, productId);
		  return ResponseEntity.ok(updateProduct);
	 }
	 
	 
	 @GetMapping("getAll")
		public ResponseEntity<List<ProductDto>> getAllproduct() {
			return ResponseEntity.ok(this.productService.getAllProduct());
		 		
	  }
	 
	 @GetMapping("getById/{productId}")
		public ResponseEntity<ProductDto> getProductByIds(@PathVariable Integer productId) {
		  return ResponseEntity.ok(productService.getProductById(productId));
			
	 }
	 
	 @DeleteMapping("deleteById/{productId}") 
	 public ResponseEntity< ?> deleteProduct(@PathVariable Integer productId)
	{
	      this.productService.deleteProduct(productId);
		
		return new ResponseEntity(Map.of("message", "product deleted successfully"),HttpStatus.OK);   
		
	}
}
