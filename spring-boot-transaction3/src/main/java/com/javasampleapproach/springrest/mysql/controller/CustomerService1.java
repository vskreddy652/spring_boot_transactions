package com.javasampleapproach.springrest.mysql.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.javasampleapproach.springrest.mysql.model.Customer;
import com.javasampleapproach.springrest.mysql.repo.CustomerRepository;

class MyOwnException extends Exception{
	
}

@Service
public class CustomerService1 {
	
	@Autowired
	CustomerRepository repository;
	
	/* Whereever readOnly = false only read operations can be
	 * performed by such method
	 */
	@Transactional(readOnly = true) //data does not get saved now
	public Customer internalMethod(Customer customer) throws Exception
	{
		Customer _customer = repository.save(new Customer(customer.getName(), customer.getAge()));

		return _customer;
	}

}
