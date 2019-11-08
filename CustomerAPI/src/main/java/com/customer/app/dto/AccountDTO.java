package com.customer.app.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.customer.app.entity.Payee;

import lombok.Data;

@Data
public class AccountDTO {

	private String accountNumber;

	private String name;

	private BigDecimal balance;

	private Long customerId;

	private List<TransactionDTO> transactions = new ArrayList<>();
	
	private List<PayeeDTO> payees=new ArrayList<>();

}
