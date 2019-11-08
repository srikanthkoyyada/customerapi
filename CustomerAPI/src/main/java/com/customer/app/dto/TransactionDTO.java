package com.customer.app.dto;

import lombok.Data;

@Data
public class TransactionDTO {

	private Long transactionId;

	private String tranAmount;

	private String tranSourceAccount;

	private String tranTargetAccount;

	private java.util.Date tranDateTime;

	private String customerAccount;
	
	private String tranType;

}
