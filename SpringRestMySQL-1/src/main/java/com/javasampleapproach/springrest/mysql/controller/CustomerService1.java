package com.javasampleapproach.springrest.mysql.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.javasampleapproach.springrest.mysql.model.Customer;
import com.javasampleapproach.springrest.mysql.repo.CustomerRepository;

@Service
public class CustomerService1 {
	
	@Autowired
	CustomerService2 service2;
	
	@Autowired
	CustomerRepository repository;
	
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
	public Customer internalMethod(Customer customer)
	{
		Customer _customer = repository.save(new Customer(customer.getName(), customer.getAge()));
		//not commited
		
		service2.internalMethod1(_customer);
		//commited
		
		if(false) {
		//thorw exception so that book will not save in DB
		throw new RuntimeException("this exception in throwing intentionally");
		}
		
		return _customer;
	}

}
