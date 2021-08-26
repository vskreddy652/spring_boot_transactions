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
	
	/* As known, by default TRansactions are rolledback
	 * only when UnChecked Exception is raised.
	 * Below we added rollbackFor, so that Transactions are
	 * rolled back only when MyOwnExcepion occurs
	 */
	@Transactional(rollbackFor = MyOwnException.class)
	public Customer internalMethod(Customer customer) throws Exception
	{
		Customer _customer = repository.save(new Customer(customer.getName(), customer.getAge()));

		
		if(true) {
		//thorw exception so that book will not save in DB
		//throw new MyOwnException();
			//int z = 200/0;
		//RuntimeException("this exception in throwing intentionally");
		}
		
		return _customer;
	}

}
