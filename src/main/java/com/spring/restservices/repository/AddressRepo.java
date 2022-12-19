package com.spring.restservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.restservices.entity.Address;

public interface AddressRepo extends JpaRepository<Address, Long> {

}
