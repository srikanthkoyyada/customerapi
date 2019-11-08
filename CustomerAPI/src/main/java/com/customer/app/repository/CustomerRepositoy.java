package com.customer.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.customer.app.entity.Customer;

@Repository
public interface CustomerRepositoy extends JpaRepository<Customer, String> {
	
	Optional<Customer> findByUsername(String username);

}
