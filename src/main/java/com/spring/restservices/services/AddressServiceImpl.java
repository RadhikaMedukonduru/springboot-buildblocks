package com.spring.restservices.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.restservices.entity.Address;
import com.spring.restservices.repository.AddressRepo;

@Service
public class AddressServiceImpl implements AddressService{
	
	@Autowired
	private AddressRepo addressRepo;

	@Override
	public List<Address> getAddress() {
		return null;
	}

	@Override
	public Address createAddress(Address address) {
		// TODO Auto-generated method stub
		return addressRepo.save(address);
	}

}
