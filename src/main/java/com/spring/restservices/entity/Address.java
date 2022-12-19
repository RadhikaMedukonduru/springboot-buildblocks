package com.spring.restservices.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Address {
	
	@Id
	@GeneratedValue
	private Long addressId;
	
	@Column
	private String city;
	
	@Column
	private String state;
	
	@Column
	private String zipcode;
	
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Address(Long addressId, String city, String state, String zipcode, User user) {
		super();
		this.addressId = addressId;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
	}

	public Long getAddressId() {
		return addressId;
	}

	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", city=" + city + ", state=" + state + ", zipcode=" + zipcode + "]";
	}


	

}
