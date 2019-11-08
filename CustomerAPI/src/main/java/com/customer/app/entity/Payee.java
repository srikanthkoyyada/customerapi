package com.customer.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="CUSTOMER_PAYEE")
@Data
public class Payee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long payeeId;
	@Column
	private String name;
	@Column
	private String nickName;
	@Column
	private String payeeAccountNumber;
	@Column
	private String ifscCode;
	@Column
	private String accountNumber;
	@Column
	private int isVerified=0;

}
