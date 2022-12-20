package com.spring.restservices.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="orders")
public class Orders {
	
	@Id
	@Column
	@GeneratedValue(strategy =GenerationType.AUTO)
	private Long orderId;
	

	@Column
	private String orderDesc;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	private User user;


	public Long getOrderId() {
		return orderId;
	}


	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}


	public String getOrderDesc() {
		return orderDesc;
	}


	public void setOrderDesc(String orderDesc) {
		this.orderDesc = orderDesc;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public Orders(Long orderId, String orderDesc, User user) {
		super();
		this.orderId = orderId;
		this.orderDesc = orderDesc;
		this.user = user;
	}


	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "OderDetails [orderId=" + orderId + ", orderDesc=" + orderDesc + ", user=" + user + "]";
	}
	
	

}
