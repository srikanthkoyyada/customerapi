package com.customer.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "CUSTOMER")
@Data
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long customerId;
	@Column(name = "username", unique = true)
	private String username;
	@Column(name = "password")
	private String password;
	@Column(name = "last_visit")
	private java.util.Date lastVisit;

}
