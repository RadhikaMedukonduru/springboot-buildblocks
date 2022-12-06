package com.spring.restservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.restservices.entity.Orders;

public interface OrderRepository extends JpaRepository<Orders, Long> {

}
