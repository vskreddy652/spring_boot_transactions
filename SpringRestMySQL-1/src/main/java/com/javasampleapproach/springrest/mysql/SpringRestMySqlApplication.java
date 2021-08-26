package com.javasampleapproach.springrest.mysql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class SpringRestMySqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRestMySqlApplication.class, args);
	}
}
