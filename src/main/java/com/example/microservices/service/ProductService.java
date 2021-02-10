package com.example.microservices.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.microservices.entity.Product;
import com.example.microservices.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository repo;

	public ResponseEntity<Product> getProductById(Long id) {
		Optional<Product> prod = repo.findById(id);
		if (!prod.isPresent()) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok(prod.get());
	}

	public List<Product> getAllProducts() {
		return repo.findAll();
	}

}
