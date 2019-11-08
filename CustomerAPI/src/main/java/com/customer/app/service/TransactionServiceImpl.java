package com.customer.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.app.repository.TransactionsRepositoy;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	private TransactionsRepositoy transactionRepository;

}
