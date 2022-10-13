package com.nikhil.Customer.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.nikhil.Customer.entity.product;
@Repository
public class ProductDao {

	public static final String HASH_KEY="Product";
	@Autowired
	@Qualifier("redisTemplate")
	private RedisTemplate template;
	public product save(product p) {
		template.opsForHash().put(HASH_KEY,p.getId(),p);
		return p;
	}
	public List<product> findAll(){
		return template.opsForHash().values(HASH_KEY);
	}
	public product findProductById(int id) {
		System.out.println("Called findProductById() from DB"); 
		return (product)template.opsForHash().get(HASH_KEY, id);
	}
	public String deleteproduct(int id) {
		template.opsForHash().delete(HASH_KEY, id);
		return "product removed !!";
	}
}
