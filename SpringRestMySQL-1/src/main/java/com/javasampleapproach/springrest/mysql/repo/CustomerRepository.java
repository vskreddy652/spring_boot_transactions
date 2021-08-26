package com.javasampleapproach.springrest.mysql.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.javasampleapproach.springrest.mysql.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
	List<Customer> findByAge(int age);
	
    @Query("SELECT p FROM Customer p WHERE LOWER(p.name) = LOWER(:name)")
    public List<Customer> findXyz(@Param("name") String name);
}
