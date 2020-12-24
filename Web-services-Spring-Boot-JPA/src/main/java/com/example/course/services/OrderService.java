package com.example.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.course.model.Order;
import com.example.course.repositories.OrderRepository;

@Component
public class OrderService {

	@Autowired
	private OrderRepository repository;

	public OrderRepository getRepository() {
		return this.repository;
	}

	public List<Order> fetchAll() {
		return getRepository().findAll();
	}

	public Order fetchOrderById(Long id) {
		Optional<Order> Order = getRepository().findById(id);
		return Order.get();
	}
}
