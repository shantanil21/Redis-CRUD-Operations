package com.springboot.redis.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.springboot.redis.entity.Product;

@Repository
public class ProductDao {

	public static final String HASH_KEY = "Product";
	@Autowired
	//@Qualifier(value = "redisTemplate")
	private RedisTemplate template;
	
	
	
	//to save a product
	public Product save(Product product)
	{
		template.opsForHash().put(HASH_KEY, product.getId(), product);
		return product;
		
	}
	
	//to find all the products
	public List<Product> findAll()
	{
		return template.opsForHash().values(HASH_KEY);
	}
	
	
	//find a single product
	public Product findProductById(int id)
	{
		return(Product) template.opsForHash().get(HASH_KEY,id); 
	}
	
	
	//delete a specific product
	public String deleteProductById(int id)
	{
		template.opsForHash().delete(HASH_KEY, id);
		return "Product Removed!!";
	}
}
