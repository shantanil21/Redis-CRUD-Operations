package com.springboot.redis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.springboot.redis.entity.Product;
import com.springboot.redis.repository.ProductDao;

@RestController
public class ProductController {

	@Autowired
	private ProductDao dao;
	
	@PostMapping("/products")
	public Product save(@RequestBody Product product)
	{
		return dao.save(product);
	}
	
	@GetMapping("/products")
	public List<Product> getAllProducts()
	{
		return dao.findAll();
	}
	
	@GetMapping("/products/{id}")
	public Product findProductById(@PathVariable int id)
	{
		return dao.findProductById(id);
	}
	
	@DeleteMapping("/products/{id}")
	public String deleteProductById(@PathVariable int id)
	{
		dao.deleteProductById(id);
		return "The ietm was deleted!!";
	}
	
	
	
	
	
}
