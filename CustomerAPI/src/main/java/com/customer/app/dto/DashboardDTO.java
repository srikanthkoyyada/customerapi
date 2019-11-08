package com.customer.app.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class DashboardDTO {
	
	private String name;
	private String lastVisitedDateAndTime;
	private BigDecimal AccountBalance;
	

}
