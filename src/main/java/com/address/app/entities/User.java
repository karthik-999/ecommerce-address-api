package com.address.app.entities;

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

@Data
@Entity
@Table(name = "TBL_USER")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "USER_NAME", nullable = false)
	private String userName;
	
	@Column(name = "FIRST_NAME", nullable = false)
	private String firstName;
	
	@Column(name = "LAST_NAME", nullable = false)
	private String lastName;
	
	@Column(name = "GENDER", nullable = false)
	private String gender;
	
	@Column(name = "MMEBER_TYPE", nullable = false)
	private String memberType;
	
	@Column(name = "ACCOUNT_NUMBER", nullable = false)
	private String accountNumber;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "REGISTRATION_DATE", unique = true, nullable = false, length = 10)
	private Date rgistrationDate;

}
