package com.customer.app.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(value = Include.NON_NULL)
public class CustomerResponseDTO {

	private String message;
	private String status;
	private DashboardDTO dashboard;
	private AccountDTO accountDTO;
	private int otp;
	private List<String> errors;

}
