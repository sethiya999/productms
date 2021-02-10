//package com.example.microservices.controller;
//
//import java.util.List;
//
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//import com.example.microservices.entity.Product;
//
//@FeignClient("prodfeign")
//public interface ProductFeign {
//
//	@RequestMapping(value="/{id}", method = RequestMethod.GET, produces = "application/json")
//	public Product getProductById(@PathVariable Long id);
//
//	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json")
//	public List<Product> findAll();
//}
