package com.spring.restservices.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="user")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
	
	//userName and ssn are unique and Id is primary key
	
	@Column
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name="USER_NAME",length=25,nullable=false,unique=true)
	private String userName;
	
	@Column(name="FIRST_NAME",length=25,nullable=false)
	private String firstName;
	
	@Column(name="LAST_NAME",length=25,nullable=false)
	private String lastName;
	
	@Column(name="EMAIL",length=50,nullable=false)
	private String email;
	
	@Column(name="ROLE",length=25,nullable=false)
	private String role;
	
	@Column(name="SSN",length=25,nullable=false,unique=true)
	private String ssn;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	
}