package com.customer.app.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="ACCOUNT")
@Data
public class Account {
	
	@Id
	@Column(name="ACCOUNT_NUMBER")
	private String accountNumber;
	@Column(name="name")
	private String name;
	@Column(name="balance")
	private BigDecimal balance;
	@Column
	private Long customerId;
		
	@OneToMany
	@JoinColumn(name="accountNumber")
	private List<Transaction> transactions=new ArrayList<>();
	
	@OneToMany
	@JoinColumn(name="accountNumber")
	private List<Payee> payees=new ArrayList<>();
	
	

}
