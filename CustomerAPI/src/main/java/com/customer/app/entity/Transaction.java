package com.customer.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Entity
@Table(name="TRANSACTION")
@Data
public class Transaction {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long transactionId;
	
	@Column
	private String tranAmount;
	
	@Column
	private String tranSourceAccount;
	
	@Column
	private String tranTargetAccount;
	
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date tranDateTime=new java.util.Date();
	
	@Column 
	private String accountNumber;
	
	@Column
	private String tranType;
	
}
