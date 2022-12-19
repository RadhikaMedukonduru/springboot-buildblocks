package com.spring.restservices.services;

import java.util.List;

import com.spring.restservices.entity.Address;

public interface AddressService {
	
	public List<Address> getAddress() ;
	
	Address createAddress(Address address);
	
	

}
