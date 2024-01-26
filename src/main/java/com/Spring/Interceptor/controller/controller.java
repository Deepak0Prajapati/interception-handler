package com.Spring.Interceptor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Spring.Interceptor.model.product;
import com.Spring.Interceptor.repository.productRepository;

@RestController
public class controller {
	
	@Autowired
	private productRepository productRepository;
	
	@PostMapping("/products")
	public product save(@RequestBody product p) {
		product save = productRepository.save(p);
		return save;
	}
	
	@GetMapping("/products/{id}")
	public ResponseEntity<product> findById(@PathVariable Integer id){
		product p = productRepository.findById(id).get();
		return ResponseEntity.ok().body(p);
		
	}

}
