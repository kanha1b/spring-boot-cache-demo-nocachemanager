package com.github.knutangitprjctcachedemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class KnutanGitprjctCachedemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(KnutanGitprjctCachedemoApplication.class, args);
	}

}
