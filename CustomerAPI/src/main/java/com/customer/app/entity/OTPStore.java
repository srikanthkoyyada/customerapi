package com.customer.app.entity;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

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
@Table(name="OTP_STORE")
@Data
public class OTPStore {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column
	private Long customerId;
	@Column
	private String otpFor;
	@Column
	private int otp;
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate=new Date();
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date validTill;
	@Column
	private int isUsed=0;
	
	public OTPStore() {
		super();
		Calendar calendar=Calendar.getInstance();
		calendar.add(Calendar.MINUTE, 3);
		this.validTill=calendar.getTime();
	}
	
	
	
	

}
