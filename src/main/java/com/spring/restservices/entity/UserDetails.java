package com.spring.restservices.entity;

public class UserDetails {
	
	private String fistName;
	private String lastName;
	private String city;
	public String getFistName() {
		return fistName;
	}
	public void setFistName(String fistName) {
		this.fistName = fistName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	public UserDetails(String fistName, String lastName, String city) {
		super();
		this.fistName = fistName;
		this.lastName = lastName;
		this.city = city;
	}
	@Override
	public String toString() {
		return "UserDetails [fistName=" + fistName + ", lastName=" + lastName + ", city=" + city + "]";
	}
	public UserDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
