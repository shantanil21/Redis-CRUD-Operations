package com.springboot.redis.entity;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@RedisHash("Product")
public class Product implements Serializable{

	@Id
	private int id;
	private String name;
	private int quantity;
	private long price;
	
	public Product()
	{
		super();
	}
	
	public Product(int id,String name,int quantity,long price)
	{
		this.id = id;
		this.name = name;
		this.quantity = quantity;
		this.price= price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}
	
	
	
}
