package com.spring.restservices.entity;

public class UserDtoV2 {
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private Address address;

	public UserDtoV2() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserDtoV2(String firstName, String lastName, String email, Address address) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.address = address;
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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "UserDtoV2 [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", address="
				+ address + "]";
	}
	
	

}
