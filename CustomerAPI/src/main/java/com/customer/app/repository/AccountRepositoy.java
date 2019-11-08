package com.customer.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.customer.app.entity.Account;

@Repository
public interface AccountRepositoy extends JpaRepository<Account, String> {

	Optional<Account> findByCustomerId(Long customerId);
}
