package com.spring.restservices.entity;

public class UserMsDTO {
	
	private String firstName;
	private String LastName;
	private String emailAddress;
	
	public UserMsDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public UserMsDTO(String firstName, String lastName, String emailAddress) {
		super();
		this.firstName = firstName;
		LastName = lastName;
		this.emailAddress = emailAddress;
	}



	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}



	@Override
	public String toString() {
		return "UserMsDTO [firstName=" + firstName + ", LastName=" + LastName + ", emailAddress=" + emailAddress + "]";
	}
	
	
	
	

}
