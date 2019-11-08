package com.customer.app.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerRequestDTO {
	
	private String username;
	private String password;
	private int otpCode;

}
