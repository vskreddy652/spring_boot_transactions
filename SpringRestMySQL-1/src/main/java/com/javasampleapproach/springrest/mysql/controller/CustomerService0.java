package com.javasampleapproach.springrest.mysql.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javasampleapproach.springrest.mysql.model.Customer;
import com.javasampleapproach.springrest.mysql.repo.CustomerRepository;

@Service
public class CustomerService0 {
@Autowired
CustomerRepository repository;

	//Basic Transaction Example
	@Transactional
	public Customer internalMethod(Customer customer) 
	{
		Customer _customer = repository.save(new Customer(customer.getName(), customer.getAge()));

		if(false)
		throw new RuntimeException("aaaaaa");
	
		//NOTE: When above line uncommented record is not inserted 
		//as Exception occurs and record saved gets rolled back
		return _customer;
	}

}
