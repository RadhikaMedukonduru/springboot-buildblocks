package com.spring.restservices.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.restservices.entity.Orders;
import com.spring.restservices.entity.User;
import com.spring.restservices.exceptions.UserNotFoundException;
import com.spring.restservices.repository.OrderRepository;
import com.spring.restservices.services.UserService;

@RestController
@RequestMapping("/users")
public class OrderController {

	@Autowired
	private UserService userService;

	@Autowired
	private OrderRepository orderRepo;

	@PostMapping("{userId}/orders")
	public Orders createOrder(@PathVariable Long userId, @RequestBody Orders order) throws UserNotFoundException {
			Optional<User> userById = userService.getUserById(userId);
			
            if(!userById.isPresent())
            {
            	throw new UserNotFoundException("User not found");
            }
            
            User user = userById.get();
            order.setUser(user);
          
            return orderRepo.save(order);
            
            
	}

	@GetMapping("{userId}/getAllOrders")
	public List<Orders> getOrdersByUserId(@PathVariable Long userId) throws UserNotFoundException {

		Optional<User> userById = userService.getUserById(userId);

	 if(!userById.isPresent()) {
		 throw new UserNotFoundException("user not found");
	 }
		return userById.get().getOrders();
	}
	
	
	@GetMapping("{userId}/orders/{orderId}")
	public Orders getOrderByOrderId(@PathVariable Long userId, @PathVariable Long orderId) throws UserNotFoundException
	{
		Optional<User> userById = userService.getUserById(userId);
		
		Optional<Orders> findOrderById  = orderRepo.findById(orderId);
		 
		if(!userById.isPresent()|| !findOrderById.isPresent()) 
		{
			throw new UserNotFoundException("User or orderId is not found");
		}
		
		
		return findOrderById.get() ;
	}
}
