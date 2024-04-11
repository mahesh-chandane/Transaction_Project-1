package com.springboot.transaction;

import org.modelmapper.ModelMapper  ;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TransactionProject1Application {

	public static void main(String[] args) {
		SpringApplication.run(TransactionProject1Application.class, args);
	}

	@Bean
	public ModelMapper ModelMapper()
	{
		return new ModelMapper();
	}
	
}
