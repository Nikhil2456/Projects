package com.nikhil.Customer.entity;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("Product")
public class product implements Serializable {
    @Id
	private int id;
	private String name;
	private int qty;
	private long price;
	
}
