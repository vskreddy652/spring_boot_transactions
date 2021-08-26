package com.javasampleapproach.springrest.mysql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/* Whereever readOnly = false only read operations can be
 * performed by such method
 * Refer files: CustomerController.java, CustomerService1
 */
@SpringBootApplication
public class SpringRestMySqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRestMySqlApplication.class, args);
	}
}
