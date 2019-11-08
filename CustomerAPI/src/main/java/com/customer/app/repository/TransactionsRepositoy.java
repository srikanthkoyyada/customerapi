package com.customer.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.customer.app.entity.Transaction;

@Repository
public interface TransactionsRepositoy extends JpaRepository<Transaction, String> {

}
