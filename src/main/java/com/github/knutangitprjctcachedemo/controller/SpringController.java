package com.github.knutangitprjctcachedemo.controller;

import java.sql.Timestamp;
import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SpringController {
	

	@RequestMapping("/cache/token/{token_no}")
	@Cacheable(value="sample")
	public String cacheingMethod(@PathVariable("token_no")int token) throws InterruptedException {
		
		
		Thread.sleep(3000);
		System.out.println("it is for caching with token number :"+token);
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		Instant instant = timestamp.toInstant();
		
		String s ="welcome to spring cache example by kanha"+instant.toEpochMilli();
		
		return s;
	}
	
	@RequestMapping(value="/cacheevict/token/{token_no}", method=RequestMethod.PUT)
	@CacheEvict(value = "sample", allEntries=true)
	public String cacheingUpdateMethod(@PathVariable("token_no")int token) throws InterruptedException {
		
		
		Thread.sleep(3000);
		System.out.println("it is for caching with token number :"+token);
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		Instant instant = timestamp.toInstant();
		
		String s ="updated"+instant.toEpochMilli();
		
		return s;
	}
}
