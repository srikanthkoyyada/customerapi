package com.customer.app.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiError {

	private int status;
	private String message;
	private List<String> filedErrors;
	public ApiError(int status, String message, List<String> filedErrors) {
		super();
		this.status = status;
		this.message = message;
		this.filedErrors = filedErrors;
	}
	
	
}
