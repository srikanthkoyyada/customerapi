package com.customer.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.customer.app.entity.Payee;

public interface PayeeRepository extends JpaRepository<Payee, Long>{

}
