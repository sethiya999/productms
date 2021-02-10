package com.example.microservices.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.microservices.dto.ProductDTO;
import com.example.microservices.entity.Product;
import com.example.microservices.service.ProductService;
//import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@EnableAutoConfiguration
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService service;

//	@Autowired
//	ProductFeign productFeign;

	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json")
	List<ProductDTO> findAll() {

		List<Product> res = service.getAllProducts(); 
		List<ProductDTO> list = new ArrayList<>();
		for (Product p : res) {
			ProductDTO dto = new ProductDTO();
			dto.setDescription(p.getDescription());
			dto.setId(p.getId());
			dto.setName(p.getName());
			list.add(dto);
		}
		return list;
	}

	ProductDTO getFallbackProduct(Long id) {
		return new ProductDTO();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
//	@HystrixCommand(fallbackMethod = "getFallbackProduct")
	public ProductDTO getProductById(@PathVariable Long id) {
		
		if (id == 999) { // to test fallback
			throw new RuntimeException("Invalid product id");
		}
		
		//use this when multiple instances of productms are running
//		ResponseEntity<Product> res = resttemplate.getForObject("http://productribbon/products/" + id, ResponseEntity.class);
//		
		
		//way1 - 
		ResponseEntity<Product> res = service.getProductById(id);
		System.out.println("***************" + res);
		
		
		Product prod = res.getBody();
		ProductDTO dto = new ProductDTO();
		
		if(res.getStatusCode() != HttpStatus.OK) {
			dto.setName("Product not found");
			return dto;
		}
		
		dto.setId(prod.getId());
		dto.setName(prod.getName());
		dto.setDescription(prod.getDescription());
		return dto;
	}
}
