package com.customer.app.dto;

import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class PayeeDTO {

	private Long payeeId;
	@NotEmpty(message="Please provide name")
	private String name;
	@NotEmpty(message="Please provide nickname")
	private String nickName;
	@NotEmpty(message="Please provide payeeAccountNumber")
	private String payeeAccountNumber;
	@NotEmpty(message="Please provide ifscCode")
	private String ifscCode;
	@NotEmpty(message="Please provide accountNumber")
	private String accountNumber;
	private int isVerified=0;

}
