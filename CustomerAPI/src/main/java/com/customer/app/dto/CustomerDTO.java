package com.customer.app.dto;

import lombok.Data;

@Data
public class CustomerDTO {

	private Long customerId;
	private String username;
	private String password;
	private java.util.Date lastVisit;
	private AccountDTO account;

}
